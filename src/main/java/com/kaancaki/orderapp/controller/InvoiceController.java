package com.kaancaki.orderapp.controller;

import com.kaancaki.orderapp.dto.AveragePriceDto;
import com.kaancaki.orderapp.dto.TotalPriceFromCustomerRegistrationDateDto;
import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.entity.Invoice;
import com.kaancaki.orderapp.dto.InvoiceDto;
import com.kaancaki.orderapp.service.impl.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Invoice>> findAll(){
        List<Invoice> invoiceList = invoiceService.findAll();

        return ResponseEntity.ok(invoiceList);
    }

    @GetMapping("/greaterThanTotalPrice")
    public ResponseEntity<List<Invoice>> findByTotalPriceGreaterThanEqual(@RequestParam(required = true, name = "price") BigDecimal price) {
        List<Invoice> invoiceList = invoiceService.findByTotalPriceGreaterThanEqual(price);

        return ResponseEntity.ok(invoiceList);
    }

    @GetMapping("/lessThanTotalPriceWithCustomerNames")
    public ResponseEntity<List<String>> findByCustomerNameTotalPriceLessThan(@RequestParam(required = true, name = "price") BigDecimal price) {
        List<String> customerNames = invoiceService.findByCustomerNameTotalPriceLessThan(price);

        return ResponseEntity.ok(customerNames);
    }

    @GetMapping("/findAveragePriceGreaterThan")
    public ResponseEntity<AveragePriceDto> findAveragePriceGreaterThan(@RequestParam(required = true, name = "price") BigDecimal price) {
        AveragePriceDto averagePriceDto = invoiceService.findAveragePriceGreaterThan(price);

        return ResponseEntity.ok(averagePriceDto);
    }

}
