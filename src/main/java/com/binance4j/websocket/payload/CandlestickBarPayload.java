package com.binance4j.websocket.payload;

import com.binance4j.core.kline.CandlestickBar;
import com.binance4j.websocket.serialization.CandlestickEventDeserializer;
import com.binance4j.websocket.serialization.CandlestickEventSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Kline/Candlestick bar for a symbol.
 */
@Data
@JsonFormat(shape = Shape.OBJECT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CandlestickBarPayload extends CandlestickBar {
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
	 * @return is it the last bar of the interval?
	 * @param isBarFinal The new value
	 */
	private Boolean isBarFinal;
}