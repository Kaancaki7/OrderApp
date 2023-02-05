package com.kaancaki.orderapp.dao;

import com.kaancaki.orderapp.entity.Company;
import com.kaancaki.orderapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyDao extends JpaRepository<Company,Long> {
}
