package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.DepthPayload;

/** Websocket client handling depth events on one or many symbols */
public class WebsocketDepthClient extends WebSocketClient<DepthPayload> {
    /**
     * Constructor with symbols separated by a coma
     * 
     * @param symbols trading pair separated by a coma
     */
    public WebsocketDepthClient(String symbols) {
        super(symbols, "depth", DepthPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketDepthClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}
