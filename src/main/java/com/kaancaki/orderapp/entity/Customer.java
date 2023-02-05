package com.kaancaki.orderapp.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

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
    @Column(name = "ID_SECTOR")
    private Long sectorId;

    @Column(name = "DATE_OF_REGISTRATION")
    private LocalDate dateOfRegistration;

}
