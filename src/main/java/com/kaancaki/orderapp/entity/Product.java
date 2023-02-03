package com.kaancaki.orderapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_SEQ_ID")
    private Long id;
    @Column(name = "NAME",length = 100)
    private String name;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "ID_CATEGORY")
    private Long categoryId;
    @Column(name = "ID_COMPANY")
    private Long companyId;
}
