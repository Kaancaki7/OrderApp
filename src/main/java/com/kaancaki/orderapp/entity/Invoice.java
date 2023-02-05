package com.kaancaki.orderapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
@Getter
@Setter
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(generator = "Invoice")
    @SequenceGenerator(name = "Invoice",sequenceName = "INVOICE_SEQ_ID")
    private Long id;
    @Column(name = "TOTAL_PRICE",precision = 19,scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "INVOICE_CREATED_DATE")
    private LocalDate invoiceCreatedDate;
    @Column(name = "ID_ORDER")
    private Long orderId;
    @Column(name = "ID_CUSTOMER")
    private Long customerId;
    @Column(name = "ID_COMPANY")
    private Long companyId;
}
