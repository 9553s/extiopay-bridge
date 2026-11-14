package com.extio.pay.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String customerNumber;

    private String fullName;

    private String email;

    public Customer() {
    }

    public Customer(String customerNumber, String fullName , String email){
        this.customerNumber = customerNumber;
        this.fullName = fullName;
        this.email =email;
    }



    public String getCustomerNumber() {
        return customerNumber;
    }


    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
