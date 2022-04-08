package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** Pair trade data */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePayload {
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
	/**
	 * @return The trade id
	 * @param tradeId The new value
	 */
	@JsonProperty("t")
	private String tradeId;
	/**
	 * @return The price
	 * @param price The new value
	 */
	@JsonProperty("p")
	private BigDecimal price;
	/**
	 * @return The price
	 * @param quantity The new value
	 */
	@JsonProperty("q")
	private BigDecimal quantity;
	/**
	 * @return The buyer order id
	 * @param buyerOrderId The new value
	 */
	@JsonProperty("b")
	private Long buyerOrderId;
	/**
	 * @return The seller order id
	 * @param sellerOrderId The new value
	 */
	@JsonProperty("a")
	private Long sellerOrderId;
	/**
	 * @return The timestamp
	 * @param tradeTime The new value
	 */
	@JsonProperty("T")
	private Long tradeTime;
	/**
	 * @return Is the buyer the market maker?
	 * @param buyerIsMarketMaker The new value
	 */
	@JsonProperty("m")
	private Boolean buyerIsMarketMaker;
	/**
	 * @return Ignore
	 * @param ignore The new value
	 */
	@JsonProperty("M")
	private Boolean ignore;
}