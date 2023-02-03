package com.kaancaki.orderapp.dao;

import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order,Long> {
}
