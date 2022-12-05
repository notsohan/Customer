package com.notsohan.customer.service;

import com.notsohan.customer.exception.NotFoundException;
import com.notsohan.customer.model.Customer;
import com.notsohan.customer.model.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    //Different Approach
    public Customer getCustomer(Long customerId) {
        return getCustomers()
                .stream()
                .filter(customer -> customer.getCustId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Customer with "+ customerId +" not found!"));
    }

    public void deleteCustById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer custDB = customerRepository.findById(customerId).get();
        if(Objects.nonNull(customer.getCusName()) &&
        !"".equalsIgnoreCase(customer.getCusName())){
            custDB.setCusName(customer.getCusName());
        }
        if(Objects.nonNull(customer.getCusEmail()) &&
                !"".equalsIgnoreCase(customer.getCusEmail())){
            custDB.setCusEmail(customer.getCusEmail());
        }

        return customerRepository.save(custDB);
    }

    public Customer getCustByName(String cusName) {
        return customerRepository.findByCusName(cusName);
    }
}
