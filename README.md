# binance4j-websocket

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-websocket/badge.svg)](https://search.maven.org/search?q=com.binance4j)
[![Sonatype Nexus](https://img.shields.io/nexus/r/com.binance4j/binance4j-websocket?server=https%3A%2F%2Fs01.oss.sonatype.org%2F)](https://s01.oss.sonatype.org/#nexus-search;quick~com.binance4j)
![Build Status develop](https://img.shields.io/github/workflow/status/binance4j/binance4j-websocket/Deploy%20Artifact%20on%20Maven%20then%20merge%20on%20main/deploy?label=Test)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![JDK](https://upload.wikimedia.org/wikipedia/commons/7/75/Blue_JDK_1.8%2B_Shield_Badge.svg)
[![javadoc](https://img.shields.io/badge/javadoc-latest-informational)](https://binance4j.github.io/binance4j-websocket)
[![binance doc](https://img.shields.io/badge/binance%20doc-webscoket-gold)](https://binance-docs.github.io/apidocs/spot/en/#websocket-market-streams)

Binance4j-websocket is a Java library for interacting with the Binance Websockets API

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-websocket</artifactId>
  <version>1.3.2</version>
</dependency>
```

### AggTrade client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/#aggregate-trade-streams)

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

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-streams)

```java
WebsocketCandlestickClient client  = new WebsocketCandlestickClient("BTCBUSD", CandlestickInterval.ONE_MINUTE);
```

### Trade client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#trade-streams)

```java
WebsocketTradeClient client  = new WebsocketTradeClient("BTCBUSD");
```

### Ticker client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/#individual-symbol-ticker-streams)

```java
WebsocketTickerClient client  = new WebsocketTickerClient("BTCBUSD");
```

### Ticker client for all symbols

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#all-market-tickers-stream)

```java
WebsocketAllTickersClient client  = new WebsocketAllTickersClient();
```

### MiniTicker client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#individual-symbol-mini-ticker-stream)

```java
WebsocketTickerClient client  = new WebsocketTickerClient("BTCBUSD");
```

### MiniTicker client for all symbols

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#all-market-mini-tickers-stream)

```java
WebsocketAllMiniTickersClient client  = new WebsocketAllMiniTickersClient();
```

### Book ticker client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/#individual-symbol-ticker-streams)

```java
WebsocketBookTickerClient client  = new WebsocketBookTickerClient("BTCBUSD");
```

### Book ticker client for all symbols

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#all-book-tickers-stream)

```java
WebsocketAllBookTickersClient client  = new WebsocketAllBookTickersClient();
```

### Depth client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#diff-depth-stream)

```java
WebsocketDepthClient client  = new WebsocketDepthClient("BTCBUSD");
```

### MiniDepth client

[![binance doc](https://img.shields.io/badge/binance%20doc-websocket-gold)](https://binance-docs.github.io/apidocs/spot/en/#all-book-tickers-stream)

```java
WebsocketMiniDepthClient client  = new WebsocketMiniDepthClient("BTCBUSD");
```
