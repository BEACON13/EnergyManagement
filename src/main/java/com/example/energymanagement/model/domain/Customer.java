package com.example.energymanagement.model.domain;

import java.util.Objects;

public class Customer {
    private Integer cId;

    private String name;

    private String billingAddress;

    private String phone;

    private String password;

    public Customer() {
    }

    public Customer(Integer cId, String name, String billingAddress, String phone) {
        this.cId = cId;
        this.name = name;
        this.billingAddress = billingAddress;
        this.phone = phone;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getcId(), customer.getcId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getBillingAddress(), customer.getBillingAddress()) && Objects.equals(getPhone(), customer.getPhone()) && Objects.equals(getPassword(), customer.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getcId(), getName(), getBillingAddress(), getPhone(), getPassword());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
