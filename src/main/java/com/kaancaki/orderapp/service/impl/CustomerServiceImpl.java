package com.kaancaki.orderapp.service.impl;

import com.kaancaki.orderapp.converter.CustomerMapper;
import com.kaancaki.orderapp.dto.CustomerDto;
import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.service.CustomerService;
import com.kaancaki.orderapp.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerEntityService customerEntityService;

    @Override
    public Customer save(CustomerDto customerDto) {

        Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(customerDto);

        customer = customerEntityService.save(customer);

        return customer;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = customerEntityService.findById(id);

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = customerEntityService.findAll();

        return customerList;
    }

    @Override
    public List<Customer> findByNameContainsIgnoreCase(char query) {
        List<Customer> customerList = customerEntityService.findByNameContainsIgnoreCase(query);

        return customerList;
    }

    @Override
    public List<Customer> findByDateOfRegistrationMonth(int month) {
        List<Customer> customerList = customerEntityService.findByDateOfRegistrationMonth(month);

        return customerList;
    }

    @Override
    public List<Customer> findByIds(List<Long> ids) {
        List<Customer> customerList = customerEntityService.findByIds(ids);

        return customerList;
    }


}
