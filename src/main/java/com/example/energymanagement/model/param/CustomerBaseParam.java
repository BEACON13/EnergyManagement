package com.example.energymanagement.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CustomerBaseParam {

    private Integer cId;

    private String name;

    private String email;

    private String billingAddress;

    private String phone;

    private String password;

}
