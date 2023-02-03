package com.kaancaki.orderapp.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(generator = "Customer")
    @SequenceGenerator(name = "Customer",sequenceName = "CUSTOMER_SEQ_ID")
    private Long id;
    @Column(name = "NAME",length = 60,nullable = false)
    private String name;
    @Column(name = "SURNAME",length = 60,nullable = false)
    private String surname;
    private LocalDate dateOfRegistration;

}
