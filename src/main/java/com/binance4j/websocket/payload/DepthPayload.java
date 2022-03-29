package com.binance4j.websocket.payload;

import java.util.List;

import com.binance4j.core.depth.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** The symbol depth */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthPayload {
        /**
         * The event type
         * 
         * @param eventType The new value
         */
        @JsonProperty("e")
        private String eventType;
        /**
         * @return The timestamp
         * @param eventTime The new value
         */
        @JsonProperty("E")
        private Long eventTime;
        /**
         * @return The trading pair
         * @param symbol The new value
         */
        @JsonProperty("s")
        private String symbol;
        /**
         * @return first update id
         * @param firstUpdateId The new value
         */
        @JsonProperty("U")
        private Long firstUpdateId;
        /**
         * @return last update id
         * @param finalUpdateId The new value
         */
        @JsonProperty("u")
        private Long finalUpdateId;
        /**
         * @return The offers
         * @param bids The new value
         */
        @JsonProperty("b")
        private List<OrderBookEntry> bids;
        /**
         * @return The demands
         * @param asks The new value
         */
        @JsonProperty("a")
        private List<OrderBookEntry> asks;
}