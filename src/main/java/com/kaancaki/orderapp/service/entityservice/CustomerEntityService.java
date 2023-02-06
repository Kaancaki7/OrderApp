package com.kaancaki.orderapp.service.entityservice;

import com.kaancaki.orderapp.dao.CustomerDao;
import com.kaancaki.orderapp.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {

    private final CustomerDao customerDao;

    public Customer save(Customer customer){
        customer.setDateOfRegistration(LocalDate.now());

        return customerDao.save(customer);
    }

    public Customer findById(Long id) {
        Optional<Customer> optionalCustomer = customerDao.findById(id);

        if (!optionalCustomer.isPresent()) {
            throw new RuntimeException("Customer Not Found!");
        }

        return optionalCustomer.get();
    }

    public List<Customer> findAll() {
        List<Customer> customerList = customerDao.findAll();

        return customerList;
    }

    public List<Customer> findByNameContainsIgnoreCase(char query) {
        List<Customer> customerList = customerDao.findByNameContainsIgnoreCase(query);

        return customerList;
    }

    public List<Customer> findByDateOfRegistrationMonth(int month) {
        List<Customer> customerList = customerDao.findByDateOfRegistrationMonth(month);

        return customerList;
    }

    public List<Customer> findByIds(List<Long> ids) {
        List<Customer> customerList = customerDao.findByIds(ids);

        return customerList;
    }

}
