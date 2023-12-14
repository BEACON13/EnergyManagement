package com.example.energymanagement.model.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class ServiceLocation {

    private Integer sId;

    private Integer cId;

    private String address;

    private LocalDateTime moveInDate;

    private Integer size;

    private Integer bedroomNum;

    private Integer occupantNum;

    private String zipCode;

    public ServiceLocation() {
    }

    public ServiceLocation(Integer sId, Integer cId, String address, LocalDateTime moveInDate, Integer size, Integer bedroomNum, Integer occupantNum, String zipCode) {
        this.sId = sId;
        this.cId = cId;
        this.address = address;
        this.moveInDate = moveInDate;
        this.size = size;
        this.bedroomNum = bedroomNum;
        this.occupantNum = occupantNum;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceLocation that)) return false;
        return Objects.equals(getSId(), that.getSId()) && Objects.equals(getCId(), that.getCId()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getMoveInDate(), that.getMoveInDate()) && Objects.equals(getSize(), that.getSize()) && Objects.equals(getBedroomNum(), that.getBedroomNum()) && Objects.equals(getOccupantNum(), that.getOccupantNum()) && Objects.equals(getZipCode(), that.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSId(), getCId(), getAddress(), getMoveInDate(), getSize(), getBedroomNum(), getOccupantNum(), getZipCode());
    }

    @Override
    public String toString() {
        return "ServiceLocation{" +
                "sId=" + sId +
                ", cId=" + cId +
                ", address='" + address + '\'' +
                ", moveInDate=" + moveInDate +
                ", size=" + size +
                ", bedroomNum=" + bedroomNum +
                ", occupantNum=" + occupantNum +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
