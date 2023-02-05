package com.kaancaki.orderapp.controller;

import com.kaancaki.orderapp.dto.CustomerDto;
import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.service.CustomerService;
import com.kaancaki.orderapp.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.save(customerDto);

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Customer customer = customerService.findById(id);

        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customerList = customerService.findAll();

        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/searchByIncludingLetter")
    public ResponseEntity<List<Customer>> findByNameIncludingLetter(@RequestParam(required = true, name = "query") char query) {
        List<Customer> customerList = customerService.findByNameContainsIgnoreCase(query);

        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/searchByRegistrationDate")
    public ResponseEntity<List<Customer>> findByRegistrationMonth(@RequestParam(required = true, name = "month") int month) {
        List<Customer> customerList = customerService.findByDateOfRegistrationMonth(month);

        return ResponseEntity.ok(customerList);
    }


}
