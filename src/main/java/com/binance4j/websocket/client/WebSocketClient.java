package com.binance4j.websocket.client;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.binance4j.core.configuration.CoreConfiguration;
import com.binance4j.core.exception.ApiException;

import io.reactivex.rxjava3.functions.Consumer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;

/**
 * Websocket clients base class
 */
@Data
public abstract class WebSocketClient<T> {
	/**
	 * @return The response data sent by the API
	 * @param payloadClass The new value
	 */
	protected Class<T> payloadClass;
	/**
	 * @return The symbols we want the payload
	 * @param symbols The new value
	 */
	protected String symbols;
	/**
	 * @return The data type we need / the stream we want to connect to
	 * @param stream The new value
	 */
	protected String stream;
	/**
	 * @return The wrapped websocket
	 * @param websocket The new value
	 */
	protected WebSocket websocket;
	/**
	 * @return Should we use testnet?
	 * @param useTestnet The new value
	 */
	protected boolean useTestnet;

	/** The {@link #onMessage} consumer */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<T> onMessageConsumer = (T payload) -> {
	};
	/** The {@link #onOpen} consumer */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<Response> onOpenConsumer = (Response response) -> {
	};
	/** The {@link #onClosing} consumer */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<WebsocketCloseObject> onClosingConsumer = (WebsocketCloseObject closeObject) -> {
	};
	/** The {@link #onClosed} consumer */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<WebsocketCloseObject> onClosedConsumer = (WebsocketCloseObject closeObject) -> {
	};
	/** The {@link #onFailure} consumer */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	protected Consumer<ApiException> onFailureConsumer = (ApiException response) -> {
	};

	/**
	 * Constructor
	 * 
	 * @param symbols      The pairs of assets
	 * @param stream       The stream
	 * @param payloadClass The payload type
	 */
	protected WebSocketClient(String symbols, String stream, Class<T> payloadClass) {
		this.symbols = symbols;
		this.stream = stream;
		this.payloadClass = payloadClass;
	}

	/**
	 * Triggered when payload is received
	 * 
	 * @param onMessageConsumer The response consumer
	 */
	public void onMessage(Consumer<T> onMessageConsumer) {
		this.onMessageConsumer = onMessageConsumer;
	}

	/**
	 * Triggered when stream is opened
	 * 
	 * @param onOpenConsumer The response consumer
	 */
	public void onOpen(Consumer<Response> onOpenConsumer) {
		this.onOpenConsumer = onOpenConsumer;
	}

	/**
	 * Triggered when stream is closing
	 * 
	 * @param onClosingConsumer The response consumer
	 */
	public void onClosing(Consumer<WebsocketCloseObject> onClosingConsumer) {
		this.onClosingConsumer = onClosingConsumer;
	}

	/**
	 * Triggered when stream is closed
	 * 
	 * @param onClosedConsumer The response consumer
	 */
	public void onClosed(Consumer<WebsocketCloseObject> onClosedConsumer) {
		this.onClosedConsumer = onClosedConsumer;
	}

	/**
	 * Triggered when connection fails
	 * 
	 * @param onFailureConsumer The response consumer
	 */
	public void onFailure(Consumer<ApiException> onFailureConsumer) {
		this.onFailureConsumer = onFailureConsumer;
	}

	/** Opens the stream */
	public void open() {
		if (websocket != null) {
			close();
		}

		WebsocketCallback<T> callback = new WebsocketCallback<T>() {
			@Override
			public void onResponse(T payload) {
				try {
					onMessageConsumer.accept(payload);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onClosing(int code, String reason) {
				try {
					onClosingConsumer.accept(new WebsocketCloseObject(code, reason));
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onClosed(int code, String reason) {
				try {
					onClosedConsumer.accept(new WebsocketCloseObject(code, reason));
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onOpen(Response response) {
				try {
					onOpenConsumer.accept(response);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(ApiException exception) {
				try {
					onFailureConsumer.accept(exception);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		};

		websocket = createNewWebSocket(generateChannel(symbols, stream),
				new WebSocketListener<>(callback, payloadClass));
	}

	/** Closes the stream */
	public void close() {
		websocket.close(1000, null);
	}

	/**
	 * Generate the websocket communicating with the API
	 * 
	 * @param channel  address containing the symbols and the stream name
	 * @param listener The websocket listener
	 * @return The websocket to communicate with the API
	 */
	protected WebSocket createNewWebSocket(String channel, WebSocketListener<?> listener) {
		String streamingUrl = String.format("%s/%s", getStreamApiBaseUrl(useTestnet), channel);
		Request request = new Request.Builder().url(streamingUrl).build();
		return new OkHttpClient.Builder()
				.dispatcher(new Dispatcher())
				.pingInterval(CoreConfiguration.getPingIntervalNum(), CoreConfiguration.getPingInterval())
				.build()
				.newWebSocket(request, listener);
	}

	/**
	 * Returns the WebSocket API base URL
	 * 
	 * @param useTestnet should the base URL be the testNet url?
	 * @return The stream base url
	 */
	protected String getStreamApiBaseUrl(boolean useTestnet) {
		return !useTestnet
				? String.format("wss://stream.%s:%s/ws", CoreConfiguration.getBaseDomain(),
						CoreConfiguration.getWebsocketPort())
				: String.format("wss://%s/ws", CoreConfiguration.getTestnetDomain());
	}

	/**
	 * Generates the channel the Websocket will connect to
	 * 
	 * @param symbols The symbols we want the market datas seperated by a coma
	 * @param stream  The stream enpoint
	 * @return The stream channel
	 */
	protected String generateChannel(String symbols, String stream) {
		return symbols == null ? stream
				: Arrays.stream(symbols.toLowerCase().split(","))
						.map(String::trim)
						.map(s -> String.format("%s@%s", s, stream))
						.collect(Collectors.joining("/"));
	}
}