package com.binance4j.websocket.payload;

import java.util.List;

import com.binance4j.core.market.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Top bids and asks
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniDepthPayload {
    /**
     * @return The last update id
     * @param lastUpdateId The new value
     */
    private Long lastUpdateId;
    /**
     * @return Bids
     * @param bids The new value
     */
    private List<OrderBookEntry> bids;
    /**
     * @return Asks
     * @param asks The new value
     */
    private List<OrderBookEntry> asks;
}
