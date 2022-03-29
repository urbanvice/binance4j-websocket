package com.binance4j.websocket.payload;

import java.util.List;

import com.binance4j.core.account.AssetBalance;
import com.binance4j.websocket.serialization.AssetBalanceDeserializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

/**
 * Account update event which will reflect the current position/balances of the
 * account.
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdatePayload
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountUpdatePayload {
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
	 * @return The assets balances
	 * @param balances The new value
	 */
	@JsonProperty("B")
	@JsonDeserialize(contentUsing = AssetBalanceDeserializer.class)
	private List<AssetBalance> balances;
}
