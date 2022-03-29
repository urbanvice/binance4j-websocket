package com.binance4j.websocket.client;

import com.binance4j.core.misc.ListenKey;
import com.binance4j.websocket.payload.UserDataUpdatePayload;

/**
 * Websocket client handling user data / balance events on one or many symbols
 */
public class WebsocketUserDataClient extends WebSocketClient<UserDataUpdatePayload> {
    /**
     * Constructor
     * 
     * @param listenKey The account identification key
     */
    public WebsocketUserDataClient(ListenKey listenKey) {
        super(null, listenKey.getListenKey(), UserDataUpdatePayload.class);
    }
}
