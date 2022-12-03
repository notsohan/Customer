package com.notsohan.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long custId;
    @NotBlank(message = "Name must be not empty!")
    private String cusName;
    @NotBlank(message = "Email must be not empty!")
    @Email
    private String cusEmail;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @NotBlank(message = "Password must be not empty!")
    private String pass;


    public Customer(Long custId, String cusName, String cusEmail, String pass) {
        this.custId = custId;
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.pass = pass;
    }

    public Customer(String cusName, String cusEmail, String pass) {
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.pass = pass;
    }

    public Customer() {
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    @JsonIgnore
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", cusName='" + cusName + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", pass=" + pass +
                '}';
    }
}
