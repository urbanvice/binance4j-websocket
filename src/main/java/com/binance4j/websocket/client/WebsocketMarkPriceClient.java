package com.binance4j.websocket.client;

import com.binance4j.websocket.payload.MarkPricePayload;

/** Websocket client handling mark price events on a symbol or symbols */
public class WebsocketMarkPriceClient extends WebSocketClient<MarkPricePayload> {
    /**
     * Constructor with symbols separated by a coma
     * 
     * @param symbols trading pair separated by a coma
     */
    public WebsocketMarkPriceClient(String symbols) {
        super(symbols, "markPrice", MarkPricePayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols The trading pair iterable
     */
    public WebsocketMarkPriceClient(Iterable<? extends CharSequence> symbols) {
        this(String.join(",", symbols));
    }
}