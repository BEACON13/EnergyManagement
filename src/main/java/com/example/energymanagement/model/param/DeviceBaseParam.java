package com.example.energymanagement.model.param;

import lombok.Data;

@Data
public class DeviceBaseParam {
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

    public DeviceBaseParam() {
    }

    public DeviceBaseParam(Integer did, String description, Integer tid, Integer sid) {
        this.did = did;
        this.description = description;
        this.tid = tid;
        this.sid = sid;
    }
}
