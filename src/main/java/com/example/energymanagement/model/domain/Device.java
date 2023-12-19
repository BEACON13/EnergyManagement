package com.example.energymanagement.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class Device {

    /**
     * device id
     */
    private Integer did;

    private String description;

    /**
     * device type ID
     */
    private Integer tid;

    /**
     * device service location ID
     */
    private Integer sid;

    public Device() {
    }

    public Device(Integer did, String description, Integer tid, Integer sid) {
        this.did = did;
        this.description = description;
        this.tid = tid;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Device{" +
                "dId=" + did +
                ", name='" + description + '\'' +
                ", tId=" + tid +
                ", sid=" + sid +
                '}';
    }
}
