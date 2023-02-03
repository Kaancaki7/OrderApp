package com.kaancaki.orderapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(generator = "Company")
    @SequenceGenerator(name = "Company",sequenceName = "COMPANY_SEQ_ID")
    private Long id;
    @Column(name = "NAME",length = 100)
    private String name;
    @Column(name = "ID_SECTOR")
    private Long sectorId;
}
