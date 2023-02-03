package com.kaancaki.orderapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SECTOR")
@Getter
@Setter
public class Sector {
    @Id
    @GeneratedValue(generator = "Sector")
    @SequenceGenerator(name = "Sector",sequenceName = "SECTOR_ID_SEQ")
    private Long id;
    @Column(name = "NAME",length = 100)
    private String name;
}
