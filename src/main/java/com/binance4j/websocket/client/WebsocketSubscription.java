package com.binance4j.websocket.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

/** ??? */
@Data
@AllArgsConstructor
public class WebsocketSubscription {
    /**
     * @return The subscription method
     * @param method The new value
     */
    private SubscriptionMethod method;
    /**
     * @return The subscription params
     * @param params The new value
     */
    private String[] params;
    /**
     * @return The subscription id
     * @param id The new value
     */
    private Long id;

    /**
     * Constructor
     * 
     * @param method  The subscription method
     * @param symbols The symbols to subscribe to
     */
    public WebsocketSubscription(SubscriptionMethod method, String[] symbols) {
        this.method = method;
        this.params = symbols;
    }

    /**
     * Converts the object into a string
     */
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}