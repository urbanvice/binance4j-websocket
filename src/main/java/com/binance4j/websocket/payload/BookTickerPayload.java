package com.binance4j.websocket.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or
 * ask's price or quantity in real-time for a specified symbol.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTickerPayload {
    /**
     * @return The update id
     * @param updateId The new value
     */
    @JsonProperty("u")
    private Long updateId;
    /**
     * @return The trading pair
     * @param symbol The new value
     */
    @JsonProperty("s")
    private String symbol;
    /**
     * @return The bid price
     * @param bidPrice The new value
     */
    @JsonProperty("b")
    private String bidPrice;
    /**
     * @return The bid quantity
     * @param bidQuantity The new value
     */
    @JsonProperty("B")
    private String bidQuantity;
    /**
     * @return The ask price
     * @param askPrice The new value
     */
    @JsonProperty("a")
    private String askPrice;
    /**
     * @return The ask quantity
     * @param askQuantity The new value
     */
    @JsonProperty("A")
    private String askQuantity;
}