package com.example.energymanagement.model.domain;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDateTime moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getBedroomNum() {
        return bedroomNum;
    }

    public void setBedroomNum(Integer bedroomNum) {
        this.bedroomNum = bedroomNum;
    }

    public Integer getOccupantNum() {
        return occupantNum;
    }

    public void setOccupantNum(Integer occupantNum) {
        this.occupantNum = occupantNum;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceLocation that)) return false;
        return Objects.equals(getsId(), that.getsId()) && Objects.equals(getcId(), that.getcId()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getMoveInDate(), that.getMoveInDate()) && Objects.equals(getSize(), that.getSize()) && Objects.equals(getBedroomNum(), that.getBedroomNum()) && Objects.equals(getOccupantNum(), that.getOccupantNum()) && Objects.equals(getZipCode(), that.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsId(), getcId(), getAddress(), getMoveInDate(), getSize(), getBedroomNum(), getOccupantNum(), getZipCode());
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
