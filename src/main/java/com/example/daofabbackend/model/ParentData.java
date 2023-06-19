package com.example.daofabbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParentData {
    private final List<Parent> parent;
    private final int totalNumber;

    public ParentData(@JsonProperty("parent") List<Parent> parent,
                  @JsonProperty("totalNumber") int totalNumber) {
        this.parent = parent;
        this.totalNumber = totalNumber;
    }

    public List<Parent> getParents() {
        return parent;
    }

    public int getTotalNumber() {
        return totalNumber;
    }
}
