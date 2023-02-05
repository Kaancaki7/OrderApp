package com.kaancaki.orderapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_ORDER")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(generator = "CUSTOMER_ORDER")
    @SequenceGenerator(name = "CUSTOMER_ORDER",sequenceName = "CUSTOMER_ORDER_SEQ_ID")
    private Long id;
    @Column(name = "ID_PRODUCT")
    private Long productId;
    @Column(name = "ID_CUSTOMER")
    private Long customerId;
    @Column(name = "PRODUCT_COUNT")
    private Long productCount;

}
