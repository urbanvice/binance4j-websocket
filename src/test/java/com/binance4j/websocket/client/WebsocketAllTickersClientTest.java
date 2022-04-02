package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.CompletableFuture;

/** endpoint doesn't seem to work */
public class WebsocketAllTickersClientTest {
    WebsocketAllTickersClient client;

    // @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketAllTickersClient();

        client.onOpen(cb -> {
            System.out.println("open");
            assertNotNull(cb.body());
        });

        client.onClosing(cb -> {
            System.out.println("closing");
        });

        client.onClosed(cb -> {
            System.out.println("closed");
            future.complete(null);
        });

        client.onFailure(cb -> {
            System.out.println("failed");
            System.out.println(cb);
            assertNotNull(cb);
        });

        client.onMessage(cb -> {
            System.out.println("message");
            System.out.println(cb);
            assertNotNull(cb.getBestAskPrice());
            assertNotNull(cb.getBestAskQuantity());
            assertNotNull(cb.getBestBidPrice());
            assertNotNull(cb.getBestBidQuantity());
            client.close();
        });

        client.open();

        try {
            future.get();
        } catch (Exception e) {
            future.complete(null);
            System.out.println(e);
            assertNotNull(e);
        }
    }
}
