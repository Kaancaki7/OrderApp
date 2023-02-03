package com.kaancaki.orderapp.dao;

import com.kaancaki.orderapp.entity.Category;
import com.kaancaki.orderapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
}
