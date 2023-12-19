package com.example.energymanagement.model.param;

import com.example.energymanagement.model.domain.ServiceLocation;

import java.time.LocalDate;
import java.util.Objects;

public class ServiceLocationBaseParam {
    private Integer sId;

    private Integer cId;

    private String address;

    private LocalDate moveInDate;

    private Integer size;

    private Integer bedroomNum;

    private Integer occupantNum;

    private String zipcode;

    public ServiceLocationBaseParam() {
    }

    public ServiceLocationBaseParam(Integer sId, Integer cId, String address, LocalDate moveInDate, Integer size, Integer bedroomNum, Integer occupantNum, String zipcode) {
        this.sId = sId;
        this.cId = cId;
        this.address = address;
        this.moveInDate = moveInDate;
        this.size = size;
        this.bedroomNum = bedroomNum;
        this.occupantNum = occupantNum;
        this.zipcode = zipcode;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceLocation that)) return false;
        return Objects.equals(getSId(), that.getSId()) && Objects.equals(getCId(), that.getCId()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getMoveInDate(), that.getMoveInDate()) && Objects.equals(getSize(), that.getSize()) && Objects.equals(getBedroomNum(), that.getBedroomNum()) && Objects.equals(getOccupantNum(), that.getOccupantNum()) && Objects.equals(getZipcode(), that.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSId(), getCId(), getAddress(), getMoveInDate(), getSize(), getBedroomNum(), getOccupantNum(), getZipcode());
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
                ", zipCode='" + zipcode + '\'' +
                '}';
    }
}
