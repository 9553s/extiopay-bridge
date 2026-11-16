package com.extio.pay.dto;

public class CustomerRequest {

    private String CustomerNumber;
    private String fullName;
    private String email;

    public CustomerRequest() {
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customer) {
        CustomerNumber = customer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
