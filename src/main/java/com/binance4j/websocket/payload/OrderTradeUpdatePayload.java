package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.ExecutionType;
import com.binance4j.core.order.OrderRejectReason;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.OrderStatus;
import com.binance4j.core.order.OrderType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdatePayload
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTradeUpdatePayload {
	/**
	 * @return The trade id
	 * @param id The new value
	 */
	@JsonProperty("i")
	private String id;
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
	 * @return Client order id
	 * @param newClientOrderId The new value
	 */
	@JsonProperty("c")
	private String newClientOrderId;
	/**
	 * @return Buy/Sell order side.
	 * @param side The new value
	 */
	@JsonProperty("S")
	private OrderSide side;
	/**
	 * @return Type of order.
	 * @param type The new value
	 */
	@JsonProperty("o")
	private OrderType type;
	/**
	 * @return Time in force to indicate how Long will the order remain active.
	 * @param timeInForce The new value
	 */
	@JsonProperty("f")
	private TimeInForce timeInForce;
	/**
	 * @return Original quantity in the order.
	 * @param originalQuantity The new value
	 */
	@JsonProperty("q")
	private BigDecimal originalQuantity;
	/**
	 * @return Price.
	 * @param price The new value
	 */
	@JsonProperty("p")
	private BigDecimal price;
	/**
	 * @return Type of execution.
	 * @param executionType The new value
	 */
	@JsonProperty("x")
	private ExecutionType executionType;
	/**
	 * @return Status of the order.
	 * @param orderStatus The new value
	 */
	@JsonProperty("X")
	private OrderStatus orderStatus;
	/**
	 * @return Reason why the order was rejected.
	 * @param orderRejectReason The new value
	 */
	@JsonProperty("r")
	private OrderRejectReason orderRejectReason;
	/**
	 * @return Order id.
	 * @param orderId The new value
	 */
	@JsonProperty("i")
	private Long orderId;
	/**
	 * @return Quantity of the last filled trade.
	 * @param quantityLastFilledTrade The new value
	 */
	@JsonProperty("l")
	private BigDecimal quantityLastFilledTrade;
	/**
	 * @return Accumulated quantity of filled trades on this order.
	 * @param accumulatedQuantity The new value
	 */
	@JsonProperty("z")
	private BigDecimal accumulatedQuantity;
	/**
	 * @return Price of last filled trade.
	 * @param priceOfLastFilledTrade The new value
	 */
	@JsonProperty("L")
	private BigDecimal priceOfLastFilledTrade;
	/**
	 * @return Commission.
	 * @param commission The new value
	 */
	@JsonProperty("n")
	private BigDecimal commission;
	/**
	 * @return Asset on which commission is taken
	 * @param commissionAsset The new value
	 */
	@JsonProperty("N")
	private String commissionAsset;
	/**
	 * @return Order/trade time.
	 * @param orderTradeTime The new value
	 */
	@JsonProperty("T")
	private Long orderTradeTime;
	/**
	 * @return Trade id.
	 * @param tradeId The new value
	 */
	@JsonProperty("t")
	private Long tradeId;
	/**
	 * @return Order creation time.
	 * @param orderCreationTime The new value
	 */
	@JsonProperty("O")
	private Long orderCreationTime;
	/**
	 * @return Cumulative quote asset transacted quantity.
	 * @param cumulativeQuoteQty The new value
	 */
	@JsonProperty("Z")
	private BigDecimal cumulativeQuoteQty;
	/**
	 * @return Last quote asset transacted quantity (i.e. lastPrice * lastQty).
	 * @param lastQuoteQty The new value
	 */
	@JsonProperty("Y")
	private BigDecimal lastQuoteQty;
	/**
	 * @return Quote Order Qty.
	 * @param quoteOrderQty The new value
	 */
	@JsonProperty("Q")
	private BigDecimal quoteOrderQty;
}