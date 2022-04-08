package com.binance4j.websocket.client;

import com.binance4j.core.kline.CandlestickInterval;
import com.binance4j.websocket.payload.CandlestickPayload;

/** Websocket client handling Kline events on one or many symbols */
public class WebsocketCandlestickClient extends WebSocketClient<CandlestickPayload> {

    /**
     * 
     * @param symbols  The symbols we want the klines
     * @param interval The candlestick interval
     */
    public WebsocketCandlestickClient(String symbols, CandlestickInterval interval) {
        super(symbols, String.format("kline_%s", interval.getValue()), CandlestickPayload.class);
    }

    /**
     * Constructor with iterable of symbols
     * 
     * @param symbols  The trading pair iterable
     * @param interval The candlestick interval
     */
    public WebsocketCandlestickClient(Iterable<? extends CharSequence> symbols, CandlestickInterval interval) {
        this(String.join(",", symbols), interval);
    }
}
