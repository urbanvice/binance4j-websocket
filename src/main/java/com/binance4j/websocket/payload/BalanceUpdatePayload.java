package com.binance4j.websocket.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Account update event which will reflect the balance changes of the account.
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdatePayload
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceUpdatePayload {
        /**
         * @return The event type
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
         * @return The asset
         * @param asset The new value
         */
        @JsonProperty("a")
        private String asset;
        /**
         * @return ???
         * @param balanceDelta The new value
         */
        @JsonProperty("d")
        private String balanceDelta;
        /**
         * @return ???
         * @param clearTime The new value
         */
        @JsonProperty("T")
        private Long clearTime;
}