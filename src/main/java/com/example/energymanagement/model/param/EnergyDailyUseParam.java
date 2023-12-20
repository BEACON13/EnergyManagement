package com.example.energymanagement.model.param;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnergyDailyUseParam {

    private Integer sid;

    private LocalDate startDate;

    private LocalDate endDate;
}
