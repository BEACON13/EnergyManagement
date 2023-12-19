package com.example.energymanagement.model.param;

import lombok.Data;

@Data
public class TypeBaseParam {

    private Integer tId;

    private String name;

    private String modelNumber;

    public TypeBaseParam() {
    }

    public TypeBaseParam(Integer tId, String tname, String modelNumber) {
        this.tId = tId;
        this.name = tname;
        this.modelNumber = modelNumber;
    }
}
