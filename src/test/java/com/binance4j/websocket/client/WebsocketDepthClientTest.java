package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

public class WebsocketDepthClientTest {
    WebsocketDepthClient client;

    @Test
    public void testClient() {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client = new WebsocketDepthClient("SHIBEUR");

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

            cb.getAsks().forEach(a -> {
                assertNotNull(a.getPrice());
                assertNotNull(a.getQt());
            });

            cb.getBids().forEach(a -> {
                assertNotNull(a.getPrice());
                assertNotNull(a.getQt());
            });

            assertNotNull(cb.getEventTime());
            assertNotNull(cb.getEventType());
            assertNotNull(cb.getFinalUpdateId());
            assertNotNull(cb.getFirstUpdateId());
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
