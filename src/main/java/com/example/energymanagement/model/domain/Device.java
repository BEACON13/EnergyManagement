package com.example.energymanagement.model.domain;

import java.util.Objects;

public class Device {

    /**
     * device id
     */
    private Integer dId;

    //TODO
    private String name;

    /**
     * device type ID
     */
    private Integer tId;

    /**
     * device service location ID
     */
    private Integer sid;

    public Device() {
    }

    public Device(Integer dId, String name, Integer tId, Integer sid) {
        this.dId = dId;
        this.name = name;
        this.tId = tId;
        this.sid = sid;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;
        return Objects.equals(getdId(), device.getdId()) && Objects.equals(getName(), device.getName()) && Objects.equals(gettId(), device.gettId()) && Objects.equals(getSid(), device.getSid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getdId(), getName(), gettId(), getSid());
    }

    @Override
    public String toString() {
        return "Device{" +
                "dId=" + dId +
                ", name='" + name + '\'' +
                ", tId=" + tId +
                ", sid=" + sid +
                '}';
    }
}
