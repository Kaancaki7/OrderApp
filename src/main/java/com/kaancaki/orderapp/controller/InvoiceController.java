package com.kaancaki.orderapp.controller;

import com.kaancaki.orderapp.dto.TotalPriceFromCustomerRegistrationDateDto;
import com.kaancaki.orderapp.entity.Invoice;
import com.kaancaki.orderapp.dto.InvoiceDto;
import com.kaancaki.orderapp.service.impl.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    @PostMapping
    public ResponseEntity<Invoice> save(@RequestBody InvoiceDto invoiceDto) {
        Invoice invoice = invoiceService.save(invoiceDto);

        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/getTotalPriceFromCustomerRegistrationDate")
    public ResponseEntity<TotalPriceFromCustomerRegistrationDateDto> getTotalPriceFromCustomerRegistrationDate(@RequestParam(required = true, name = "month") int month) {
        TotalPriceFromCustomerRegistrationDateDto totalPriceFromCustomerRegistrationDateDto = invoiceService.getTotalPriceFromCustomerRegistrationDate(month);

        return ResponseEntity.ok(totalPriceFromCustomerRegistrationDateDto);
    }

}
