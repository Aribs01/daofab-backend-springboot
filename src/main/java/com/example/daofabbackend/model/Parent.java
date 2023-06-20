package com.example.daofabbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Parent {
    private final int id;
    private final String sender;
    private final String receiver;
    private final int totalAmount;

    @Override
    public String toString() {
        return "Parent [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", totalAmount=" + totalAmount + "]";
    }
    public Parent(@JsonProperty("id") int id,
                  @JsonProperty("sender") String sender,
                  @JsonProperty("receiver") String receiver,
                  @JsonProperty("totalAmount") int totalAmount) {
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

    public int getTotalAmount() {
        return totalAmount;
    }
}
