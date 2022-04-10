# binance4j-websocket

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-websocket/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-websocket/badge.svg)

Binance4j-websocket is a Java library for interacting with the Binance Websockets API

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-websocket</artifactId>
  <version>1.1.1</version>
</dependency>
```

### AggTrade client

[Binance Documentation](https://binance-docs.github.io/apidocs/#aggregate-trade-streams)

```java
WebsocketAggTradeClient client = new WebsocketAggTradeClient("BTCBUSD");
  // Stream opened
  client.onOpen(cb -> { /** ... */ });
  // Stream is closing
  client.onClosing(cb -> { /** ... */ });
  // Stream is closed
  client.onClosed(cb -> { /** ... */ });
  // Connection failed
  client.onFailure(cb -> { /** ... */ });
  // Payload received
  client.onMessage(cb -> { /** ... */ });

  // Open the stream
  client.open();
  // CLose the stream
  client.close();

```

### Candlestick client

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-streams)

```java
WebsocketCandlestickClient client  = new WebsocketCandlestickClient("BTCBUSD", CandlestickInterval.ONE_MINUTE);
```

### Trade client

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#trade-streams)

```java
WebsocketTradeClient client  = new WebsocketTradeClient("BTCBUSD");
```

### Ticker client

[Binance Documentation](https://binance-docs.github.io/apidocs/#individual-symbol-ticker-streams)

```java
WebsocketTickerClient client  = new WebsocketTickerClient("BTCBUSD");
```

### Ticker client for all symbols

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#all-market-tickers-stream)

```java
WebsocketAllTickersClient client  = new WebsocketAllTickersClient();
```

### MiniTicker client

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#individual-symbol-mini-ticker-stream)

```java
WebsocketTickerClient client  = new WebsocketTickerClient("BTCBUSD");
```

### MiniTicker client for all symbols

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#all-market-mini-tickers-stream)

```java
WebsocketAllMiniTickersClient client  = new WebsocketAllMiniTickersClient();
```

### Book ticker client

[Binance Documentation](https://binance-docs.github.io/apidocs/#individual-symbol-ticker-streams)

```java
WebsocketBookTickerClient client  = new WebsocketBookTickerClient("BTCBUSD");
```

### Book ticker client for all symbols

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#all-book-tickers-stream)

```java
WebsocketAllBookTickersClient client  = new WebsocketAllBookTickersClient();
```

### Depth client

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#diff-depth-stream)

```java
WebsocketDepthClient client  = new WebsocketDepthClient("BTCBUSD");
```

### MiniDepth client

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#all-book-tickers-stream)

```java
WebsocketMiniDepthClient client  = new WebsocketMiniDepthClient("BTCBUSD");
```

## Javadoc

[Javadoc](https://binance4j.github.io/binance4j-websocket/)
