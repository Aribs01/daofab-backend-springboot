package com.example.daofabbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Child {
    private final int id;
    private final int parentId;
    private final BigDecimal paidAmount;

    public Child(@JsonProperty("id") int id,
                  @JsonProperty("parentId") int parentId,
                  @JsonProperty("paidAmount") BigDecimal paidAmount) {
        this.id = id;
        this.parentId = parentId;
        this.paidAmount = paidAmount;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }
}
