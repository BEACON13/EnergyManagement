package com.example.energymanagement.model.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnergyDailyUseVO {

    private Double energyUse;

    private LocalDate date;
}
