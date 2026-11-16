package com.extio.pay.dto;

public class CustomerResponse {


    private Long id;
    private String customerNumber;
    private String fullName;
    private String email;

    public CustomerResponse(){

    }


    public CustomerResponse(Long id, String customerNumber, String fullName , String email ){
        this.id = id;
        this.customerNumber = customerNumber;
        this.fullName = fullName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
