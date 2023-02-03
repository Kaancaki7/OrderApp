package com.kaancaki.orderapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(generator = "Category")
    @SequenceGenerator(name = "Category",sequenceName = "CATEGORY_ID_SEQ")
    private Long id;
    @Column(name = "NAME",length = 100)
    private String name;
}
