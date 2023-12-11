package com.example.energymanagement.model.domain;

import java.util.Objects;

public class Type {

    private Integer tId;

    private String name;

    private String modelNumber;

    public Type() {
    }

    public Type(Integer tId, String tname, String modelNumber) {
        this.tId = tId;
        this.name = tname;
        this.modelNumber = modelNumber;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type type)) return false;
        return Objects.equals(gettId(), type.gettId()) && Objects.equals(getName(), type.getName()) && Objects.equals(getModelNumber(), type.getModelNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(gettId(), getName(), getModelNumber());
    }

    @Override
    public String toString() {
        return "Type{" +
                "tId=" + tId +
                ", tname='" + name + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
