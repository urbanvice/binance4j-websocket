package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.TickerPayload;

/** Websocket client handling Kline events on one or many symbols */
public class WebsocketTickerClient extends WebSocketClient<TickerPayload> {
    /**
     * Default constructor
     * 
     * @param symbols The symbols we want the data
     */
    public WebsocketTickerClient(String symbols) {
        super(symbols, "ticker", TickerPayload.class);
    }
}
