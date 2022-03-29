package com.binance4j.websocket.client;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Contains the code and the reason of the websocket closing */
@Data
@AllArgsConstructor
public class WebsocketCloseObject {
    /**
     * @return The closing code
     * @param code The new value
     */
    private int code;
    /**
     * @return The closing reason
     * @param reason The new value
     */
    private String reason;
}