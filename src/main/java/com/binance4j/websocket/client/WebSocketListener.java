package com.binance4j.websocket.client;

import java.io.IOException;

import com.binance4j.core.exception.ApiError;
import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import okhttp3.Response;
import okhttp3.WebSocket;

/**
 * Binance API WebSocket listener.
 */
public class WebSocketListener<T> extends okhttp3.WebSocketListener {
    /**
     * @return The websocket callback
     * @param callback The new value
     */
    private final WebsocketCallback<T> callback;
    /**
     * @return The jackson object mapper
     * @param mapper The new value
     */
    private static final ObjectMapper mapper = new ObjectMapper();
    /**
     * @return Changes a string into an object
     * @param objectReader The new value
     */
    private final ObjectReader objectReader;
    /**
     * @return Makes it able to make the difference between a closing event and a
     *         failure event
     * @param closing The new value
     */
    private boolean closing = false;

    /**
     * Default constructor
     * 
     * @param callback   The websocket callback
     * @param eventClass The payload class
     */
    public WebSocketListener(final WebsocketCallback<T> callback, final Class<T> eventClass) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventClass);
    }

    /**
     * Constructor
     * 
     * @param callback           The websocket callback
     * @param eventTypeReference ???
     */
    public WebSocketListener(final WebsocketCallback<T> callback,
            final TypeReference<T> eventTypeReference) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventTypeReference);
    }

    /**
     * Callback.onResponse wrapper
     * 
     * @param webSocket The websocket
     * @param text      The payload as a string
     */
    @Override
    public void onMessage(final WebSocket webSocket, final String text) {
        try {
            callback.onResponse(objectReader.readValue(text));
        } catch (final IOException e) {
            // TODO handle onResponseException
        }
    }

    /**
     * Callback.onOpen wrapper
     * 
     * @param webSocket The websocket
     * @param response  The opening payload
     */
    @Override
    public void onOpen(final WebSocket webSocket, final Response response) {
        callback.onOpen(response);
    }

    /**
     * Callback.onClosing wrapper
     * 
     * @param webSocket The websocket
     * @param code      The closing code
     * @param reason    The closing reason
     */
    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
        callback.onClosing(code, reason);
    }

    /**
     * Callback.onClosed wrapper
     * 
     * @param webSocket The websocket
     * @param code      The closing code
     * @param reason    The closing reason
     */
    @Override
    public void onClosed(final WebSocket webSocket, final int code, final String reason) {
        closing = false;
        callback.onClosed(code, reason);
    }

    /**
     * Callback.onFailure wrapper
     * 
     * @param webSocket The websocket
     * @param t         The error object
     * @param response  The HTTP response
     */
    @Override
    public void onFailure(final WebSocket webSocket, final Throwable t, final Response response) {
        if (!closing) {
            callback.onFailure(new ApiException(new ApiError(-1000, t.getMessage())));
        }
    }
}
