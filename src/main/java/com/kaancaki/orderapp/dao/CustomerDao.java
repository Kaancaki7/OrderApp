package com.kaancaki.orderapp.dao;

import com.kaancaki.orderapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {

    public List<Customer> findByNameContainsIgnoreCase(char query);
    @Query("SELECT c FROM Customer c WHERE month(c.dateOfRegistration) = :month")
    public List<Customer> findByDateOfRegistrationMonth(@Param("month") int month);
}
