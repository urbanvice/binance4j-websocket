package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * An interval candlestick for a symbol providing informations on price that can
 * be used to produce candlestick charts.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
public class CandlestickPayload {
	/**
	 * @return The event type
	 * @param eventType The new value
	 */
	private String eventType;
	/**
	 * @return The timestmap in ms
	 * @param eventTime The new value
	 */
	private Long eventTime;
	/**
	 * @return The trading pair
	 * @param symbol The new value
	 */
	private String symbol;
	/**
	 * @return The open timestamp in ms
	 * @param openTime The new value
	 */
	private Long openTime;
	/**
	 * @return The close timestamp in ms
	 * @param closeTime The new value
	 */
	private Long closeTime;
	/**
	 * @return The opening price
	 * @param open The new value
	 */
	private BigDecimal open;
	/**
	 * @return The highest price
	 * @param high The new value
	 */
	private BigDecimal high;
	/**
	 * @return The lowest price
	 * @param low The new value
	 */
	private BigDecimal low;
	/**
	 * @return The closing price
	 * @param close The new value
	 */
	private BigDecimal close;
	/**
	 * @return The traded volume
	 * @param volume The new value
	 */
	private BigDecimal volume;
	/**
	 * @return The interval id
	 * @param intervalId The new value
	 */
	private String intervalId;
	/**
	 * @return The first trade id
	 * @param firstTradeId The new value
	 */
	private Long firstTradeId;
	/**
	 * @return The last trade id
	 * @param lastTradeId The new value
	 */
	private Long lastTradeId;
	/**
	 * @return The opposite asset volume
	 * @param quoteAssetVolume The new value
	 */
	private BigDecimal quoteAssetVolume;
	/**
	 * @return The number of trades during the interval
	 * @param numberOfTrades The new value
	 */
	private Long numberOfTrades;
	/**
	 * @return Taker completed trade volume
	 * @param takerBuyBaseAssetVolume The new value
	 */
	private BigDecimal takerBuyBaseAssetVolume;
	/**
	 * @return taker trade amount
	 * @param takerBuyQuoteAssetVolume The new value
	 */
	private BigDecimal takerBuyQuoteAssetVolume;
	/**
	 * @return is it the last bar of the interval?
	 * @param isBarFinal The new value
	 */
	private Boolean isBarFinal;
}