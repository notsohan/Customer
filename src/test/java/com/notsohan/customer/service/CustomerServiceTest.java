package com.notsohan.customer.service;

import com.notsohan.customer.model.Customer;
import com.notsohan.customer.model.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;
    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test

    void getCustomers() {
        //given
        Customer sohan = new Customer(
                1L,
                "Sohanoor Rahman",
                "sohanoorrahmansouav@gmail.com",
                "pass123"
        );
        Customer ryme = new Customer(
                2L,
                "Sheikh Araf Ryme",
                "sheikharafryme@gmail.com",
                "123pass"
        );
        //when
        customerRepository.saveAll(Arrays.asList(sohan, ryme));
        List<Customer> customers = underTest.getCustomers();
        assertEquals(2, customers.size());
    }
}