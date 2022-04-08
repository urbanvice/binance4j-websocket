package com.binance4j.websocket.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** The order book update speed */
@AllArgsConstructor
public enum DepthUpdateSpeed {

    /** Update of 1000ms */
    MS_1000("1000ms"),
    /** Update of 100ms */
    MS_100("100ms");

    /**
     * @return The result update speed
     * @param speed The new value
     */
    @Getter
    private String speed;
}
