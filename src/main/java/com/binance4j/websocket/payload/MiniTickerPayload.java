package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** Minimal infos Ticker */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniTickerPayload {
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
	 * @return The close price
	 * @param closePrice The new value
	 */
	@JsonProperty("c")
	private BigDecimal closePrice;
	/**
	 * @return The open price
	 * @param openPrice The new value
	 */
	@JsonProperty("o")
	private BigDecimal openPrice;
	/**
	 * @return The highest price
	 * @param highPrice The new value
	 */
	@JsonProperty("h")
	private BigDecimal highPrice;
	/**
	 * @return The lowest price
	 * @param lowPrice The new value
	 */
	@JsonProperty("l")
	private BigDecimal lowPrice;
	/**
	 * @return Total traded base asset volume
	 * @param totalTradedBaseAssetVolume The new value
	 */
	@JsonProperty("v")
	private BigDecimal totalTradedBaseAssetVolume;
	/**
	 * @return Total traded quote asset volume
	 * @param totalTradedQuoteAssetVolume The new value
	 */
	@JsonProperty("q")
	private BigDecimal totalTradedQuoteAssetVolume;
}