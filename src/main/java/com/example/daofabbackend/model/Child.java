package com.example.daofabbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class Child {
    private final int id;
    private final int parentId;
    private final int paidAmount;

    private Parent parent;

    public Child(@JsonProperty("id") int id,
                  @JsonProperty("parentId") int parentId,
                  @JsonProperty("paidAmount") int paidAmount,
                 @JsonProperty("parent") Parent parent) {
        this.id = id;
        this.parentId = parentId;
        this.paidAmount = paidAmount;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public Parent parent() {
        return parent;
    }

    public void setParent(Optional<Parent> parent) {
        this.parent = parent.orElse(null);
    }
}
