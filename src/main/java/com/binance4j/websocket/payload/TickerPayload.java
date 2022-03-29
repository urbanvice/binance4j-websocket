package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerPayload {
	/**
	 * @return THe event type
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
	 * @return The price change
	 * @param priceChange The new value
	 */
	@JsonProperty("p")
	private BigDecimal priceChange;
	/**
	 * @return The price change percent
	 * @param priceChangePercent The new value
	 */
	@JsonProperty("P")
	private BigDecimal priceChangePercent;
	/**
	 * @return The waighted average price
	 * @param weightedAveragePrice The new value
	 */
	@JsonProperty("w")
	private BigDecimal weightedAveragePrice;
	/**
	 * @return The previous days close price
	 * @param previousDaysClosePrice The new value
	 */
	@JsonProperty("x")
	private BigDecimal previousDaysClosePrice;
	/**
	 * @return
	 * @param currentDaysClosePrice The new value
	 */
	@JsonProperty("c")
	private BigDecimal currentDaysClosePrice;
	/**
	 * @return Last quantity
	 * @param closeTradesQuantity The new value
	 */
	@JsonProperty("Q")
	private BigDecimal closeTradesQuantity;
	/**
	 * @return Best bid price
	 * @param bestBidPrice The new value
	 */
	@JsonProperty("b")
	private BigDecimal bestBidPrice;
	/**
	 * @return Best bid quantity
	 * @param bestBidQuantity The new value
	 */
	@JsonProperty("B")
	private BigDecimal bestBidQuantity;
	/**
	 * @return Best ask price
	 * @param bestAskPrice The new value
	 */
	@JsonProperty("a")
	private BigDecimal bestAskPrice;
	/**
	 * @return Best ask quantity
	 * @param bestAskQuantity The new value
	 */
	@JsonProperty("A")
	private BigDecimal bestAskQuantity;
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
	/**
	 * @return Statistics open time
	 * @param statisticsOpenTime The new value
	 */
	@JsonProperty("O")
	private Long statisticsOpenTime;
	/**
	 * @return Statistics close time
	 * @param statisticsCloseTime The new value
	 */
	@JsonProperty("C")
	private Long statisticsCloseTime;
	/**
	 * @return First trade ID
	 * @param firstTradeId The new value
	 */
	@JsonProperty("F")
	private Long firstTradeId;
	/**
	 * @return Last trade Id
	 * @param lastTradeId The new value
	 */
	@JsonProperty("L")
	private Long lastTradeId;
	/**
	 * @return Total number of trades
	 * @param totalNumberOfTrades The new value
	 */
	@JsonProperty("n")
	private Long totalNumberOfTrades;
}