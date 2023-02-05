package com.kaancaki.orderapp.service;

import com.kaancaki.orderapp.dto.CustomerDto;
import com.kaancaki.orderapp.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(CustomerDto customerDto);

    Customer findById(Long id);

    List<Customer> findAll();

    List<Customer> findByNameContainsIgnoreCase(char query);

    List<Customer> findByDateOfRegistrationMonth(int month);
}
