package com.binance4j.websocket.serialization;

import java.io.IOException;

import com.binance4j.websocket.payload.AccountUpdatePayload;
import com.binance4j.websocket.payload.BalanceUpdatePayload;
import com.binance4j.websocket.payload.OrderTradeUpdatePayload;
import com.binance4j.websocket.payload.UserDataUpdatePayload;
import com.binance4j.websocket.payload.UserDataUpdatePayloadType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * {@link UserDataUpdatePayload} deserializer
 *
 * @see UserDataUpdatePayload
 */
public class UserDataUpdateEventDeserializer extends JsonDeserializer<UserDataUpdatePayload> {

	private ObjectMapper mapper;

	@Override
	public UserDataUpdatePayload deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

		if (mapper == null) {
			mapper = new ObjectMapper();
		}

		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		String json = node.toString();

		final String eventTypeId = node.get("e").asText();
		final Long eventTime = node.get("E").asLong();
		UserDataUpdatePayloadType userDataUpdateEventType = UserDataUpdatePayloadType.getValue(eventTypeId);
		switch (userDataUpdateEventType) {
			case ACCOUNT_POSITION_UPDATE:
				return new UserDataUpdatePayload(userDataUpdateEventType, eventTime,
						getUserDataUpdateEventDetail(json, AccountUpdatePayload.class, mapper), null, null);
			case BALANCE_UPDATE:
				return new UserDataUpdatePayload(userDataUpdateEventType, eventTime, null,
						getUserDataUpdateEventDetail(json, BalanceUpdatePayload.class, mapper), null);
			case ORDER_TRADE_UPDATE:
				return new UserDataUpdatePayload(userDataUpdateEventType, eventTime,
						null, null, getUserDataUpdateEventDetail(json, OrderTradeUpdatePayload.class, mapper));
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Deserializes the user data details
	 * 
	 * @param <T>    The user data type
	 * @param json   The input
	 * @param clazz  The type
	 * @param mapper The jackson mapper
	 * @return the user data details
	 */
	public <T> T getUserDataUpdateEventDetail(String json, Class<T> clazz, ObjectMapper mapper) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new NullPointerException();
		}
	}
}
