package com.example.daofabbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Parent {
    private final int id;
    private final String sender;
    private final String receiver;
    private final BigDecimal totalAmount;

    public Parent(@JsonProperty("id") int id,
                  @JsonProperty("sender") String sender,
                  @JsonProperty("receiver") String receiver,
                  @JsonProperty("totalAmount") BigDecimal totalAmount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
