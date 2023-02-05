package com.kaancaki.orderapp.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDto {

    private BigDecimal totalPrice;
    private Long orderId;
    private Long customerId;
    private Long companyId;
}
