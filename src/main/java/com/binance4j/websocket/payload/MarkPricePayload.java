package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** Mark price for a single symbol */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarkPricePayload {
    /**
     * @return Event type
     * @param eventType The new value
     */
    @JsonProperty("e")
    private String eventType;
    /**
     * @return Event time
     * @param eventTime The new value
     */
    @JsonProperty("E")
    private Long eventTime;
    /**
     * @return Symbol
     * @param symbol The new value
     */
    @JsonProperty("s")
    private String symbol;
    /**
     * @return Mark price
     * @param markPrice The new value
     */
    @JsonProperty("p")
    private BigDecimal markPrice;
    /**
     * @return Funding rate
     * @param fundingRate The new value
     */
    @JsonProperty("r")
    private BigDecimal fundingRate;
    /**
     * @return Next funding time
     * @param nextFundingTime The new value
     */
    @JsonProperty("T")
    private Long nextFundingTime;
}
