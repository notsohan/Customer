package com.notsohan.customer.controller;


import com.notsohan.customer.model.Customer;
import com.notsohan.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("list")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("list")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable("id") Long customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("list/{id}")
    public Customer getCustomerById(@PathVariable("id") Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("list/delete/{id}")
    public String deleteCustById(@PathVariable("id") Long customerId){
        customerService.deleteCustById(customerId);
        return "Customer deleted successfully!";
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