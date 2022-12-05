package com.notsohan.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @Column(name = "id")
    private Long custId;
    @NotBlank(message = "Name must be not empty!")
    @Column(name = "name")
    private String cusName;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @NotBlank(message = "Password must be not empty!")
    @Column(name = "password")
    private String pass;
    @NotBlank(message = "Email must be not empty!")
    @Email
    @Column(name = "email")
    private String cusEmail;

    public Customer(String cusName, String cusEmail, String pass) {
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.pass = pass;
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
}
