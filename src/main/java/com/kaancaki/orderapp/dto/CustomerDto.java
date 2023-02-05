package com.kaancaki.orderapp.dto;

import lombok.*;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private String name;
    private String surname;
    private Long sectorId;
}
