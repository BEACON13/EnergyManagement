package com.example.energymanagement.model.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private Integer eId;

    private Integer dId;

    private LocalDateTime time;

    private String eventType;

    private Double value;

    public Event() {
    }

    public Event(Integer eId, Integer dId, LocalDateTime time, String eventType, Double value) {
        this.eId = eId;
        this.dId = dId;
        this.time = time;
        this.eventType = eventType;
        this.value = value;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return Objects.equals(geteId(), event.geteId()) && Objects.equals(getdId(), event.getdId()) && Objects.equals(getTime(), event.getTime()) && Objects.equals(getEventType(), event.getEventType()) && Objects.equals(getValue(), event.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(geteId(), getdId(), getTime(), getEventType(), getValue());
    }

    @Override
    public String toString() {
        return "Event{" +
                "eId=" + eId +
                ", dId=" + dId +
                ", time=" + time +
                ", eventType='" + eventType + '\'' +
                ", value=" + value +
                '}';
    }
}
