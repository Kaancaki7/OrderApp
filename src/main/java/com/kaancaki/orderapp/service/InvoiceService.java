package com.kaancaki.orderapp.service;

import com.kaancaki.orderapp.dto.AveragePriceDto;
import com.kaancaki.orderapp.dto.InvoiceDto;
import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.entity.Invoice;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceService {

    Invoice save(InvoiceDto invoiceDto);

    List<Invoice> findAll();

    List<Invoice> findByTotalPriceGreaterThanEqual(BigDecimal price);

    List<String> findByCustomerNameTotalPriceLessThan(BigDecimal price);

    AveragePriceDto findAveragePriceGreaterThan(BigDecimal price);
}
