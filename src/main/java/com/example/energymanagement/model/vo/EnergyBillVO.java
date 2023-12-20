package com.example.energymanagement.model.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnergyBillVO {

    Double energyBill;

    LocalDate date;
}
