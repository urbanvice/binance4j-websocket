package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.TickerPayload;

/**
 * Websocket client handling ticker events on all
 * symbols.
 * 
 * @deprecated No data returned when testing the endpoint
 */
public class WebsocketAllTickersClient extends WebSocketClient<TickerPayload> {
    /**
     * Default constructor
     */
    public WebsocketAllTickersClient() {
        super("!ticker", "arr", TickerPayload.class);
    }
}
