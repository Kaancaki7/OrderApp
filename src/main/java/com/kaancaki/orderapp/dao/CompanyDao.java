package com.kaancaki.orderapp.dao;

import com.kaancaki.orderapp.entity.Company;
import com.kaancaki.orderapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company,Long> {
}
