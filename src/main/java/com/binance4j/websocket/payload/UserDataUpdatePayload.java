package com.binance4j.websocket.payload;

import com.binance4j.websocket.serialization.UserDataUpdateEventDeserializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User data update event which can be of four types:
 * <ol>
 * <li>
 * outboundAccountInfo; whenever there is a change in the account (e.g.
 * balance of an asset)
 * </li>
 * <li>
 * outboundAccountPosition; the change in account balances caused by an
 * event.
 * </li>
 * <li>
 * executionReport; whenever there is a trade or an order
 * </li>
 * <li>
 * balanceUpdate; the change in account balance (delta).
 * </li>
 * <li>
 * Deserialization could fail with UnsupportedEventException in case of
 * unsupported eventType.
 * </li>
 * </ol>
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
@AllArgsConstructor
@NoArgsConstructor
public class UserDataUpdatePayload {
	/**
	 * @return The event type
	 * @param eventType The new value
	 */
	private UserDataUpdatePayloadType eventType;
	/**
	 * @return The timestamp
	 * @param eventTime The new value
	 */
	private Long eventTime;
	/**
	 * @return The account update
	 * @param outboundAccountPositionUpdateEvent The new value
	 */
	private AccountUpdatePayload outboundAccountPositionUpdateEvent;
	/**
	 * @return The balance update
	 * @param balanceUpdateEvent The new value
	 */
	private BalanceUpdatePayload balanceUpdateEvent;
	/**
	 * @return The order trade update
	 * @param orderTradeUpdateEvent The new value
	 */
	private OrderTradeUpdatePayload orderTradeUpdateEvent;
}