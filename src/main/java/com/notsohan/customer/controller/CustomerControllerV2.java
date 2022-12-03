package com.notsohan.customer.controller;


import com.notsohan.customer.model.Customer;
import com.notsohan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2")
@Deprecated
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("list")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("list")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("list/{id}")
    public Customer getCustomerById(@PathVariable("id") Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("list/delete/{id}")
    public String deleteCustById(@PathVariable("id") Long customerId){
        customerService.deleteCustById(customerId);
        return "Department deleted successfully!";
    }


    @PutMapping("list/update/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customerId,
                                   @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }

    @GetMapping("list/name/{name}")
    public Customer getCustByName(@PathVariable("name") String custName){
        return customerService.getCustByName(custName);
    }
}