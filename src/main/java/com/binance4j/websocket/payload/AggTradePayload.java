package com.binance4j.websocket.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * An aggregated trade event for a symbol.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggTradePayload {
	/**
	 * @return The agg trade id
	 * @param aggregatedTradeId The new value
	 */
	@JsonProperty("a")
	private Long aggregatedTradeId;
	/**
	 * @return The price
	 * @param price The new value
	 */
	@JsonProperty("p")
	private String price;
	/**
	 * @return The volume
	 * @param quantity The new value
	 */
	@JsonProperty("q")
	private String quantity;
	/**
	 * @return first trade id
	 * @param firstBreakdownTradeId The new value
	 */
	@JsonProperty("f")
	private Long firstBreakdownTradeId;
	/**
	 * @return last trade id
	 * @param lastBreakdownTradeId The new value
	 */
	@JsonProperty("l")
	private Long lastBreakdownTradeId;
	/**
	 * @return The timestmap
	 * @param tradeTime The new value
	 */
	@JsonProperty("T")
	private Long tradeTime;
	/**
	 * @return Was the buyer the maker?
	 * @param isBuyerMaker The new value
	 */
	@JsonProperty("m")
	private Boolean isBuyerMaker;
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
	 * @return The trading pair
	 * @param symbol The new value
	 */
	@JsonProperty("s")
	private String symbol;
}