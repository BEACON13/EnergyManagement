package com.example.energymanagement.model.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class EnergyPrice {

    /**
     * energy price id
     */
    private Integer pId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    /**
     * energy price
     */
    private Double price;

    private String zipCode;

    public EnergyPrice() {
    }

    public EnergyPrice(Integer pId, LocalDateTime startTime, LocalDateTime endTime, Double price, String zipCode) {
        this.pId = pId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.zipCode = zipCode;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnergyPrice that)) return false;
        return Objects.equals(getpId(), that.getpId()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getZipCode(), that.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getpId(), getStartTime(), getEndTime(), getPrice(), getZipCode());
    }

    @Override
    public String toString() {
        return "EnergyPrice{" +
                "pId=" + pId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
