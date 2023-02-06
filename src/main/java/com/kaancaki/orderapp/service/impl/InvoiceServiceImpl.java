package com.kaancaki.orderapp.service.impl;

import com.kaancaki.orderapp.converter.InvoiceMapper;
import com.kaancaki.orderapp.dto.AveragePriceDto;
import com.kaancaki.orderapp.dto.InvoiceDto;
import com.kaancaki.orderapp.dto.TotalPriceFromCustomerRegistrationDateDto;
import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.entity.Invoice;
import com.kaancaki.orderapp.service.InvoiceService;
import com.kaancaki.orderapp.service.entityservice.InvoiceEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceEntityService invoiceEntityService;

    private final CustomerServiceImpl customerService;


    @Override
    public Invoice save(InvoiceDto invoiceDto) {
        Invoice invoice = InvoiceMapper.INSTANCE.invoiceDtoToInvoice(invoiceDto);

        invoice = invoiceEntityService.save(invoice);

        return invoice;
    }

    @Override
    public List<Invoice> findAll() {
        List<Invoice> invoiceList = invoiceEntityService.findAll();

        return invoiceList;
    }

    @Override
    public List<Invoice> findByTotalPriceGreaterThanEqual(BigDecimal price) {
        List<Invoice> invoiceList = invoiceEntityService.findByTotalPriceGreaterThanEqual(price);

        return invoiceList;
    }

    @Override
    public List<String> findByCustomerNameTotalPriceLessThan(BigDecimal price) {
        List<Invoice> invoiceList = invoiceEntityService.findByTotalPriceLessThanEqual(price);

        List<Long> customerIds = invoiceList.stream().map(Invoice::getCustomerId).collect(Collectors.toList());

        List<Customer> customerList = customerService.findByIds(customerIds);

        List<String> customerNameList = customerList.stream().map(Customer::getName).collect(Collectors.toList());

        return customerNameList;
    }

    @Override
    public AveragePriceDto findAveragePriceGreaterThan(BigDecimal price) {

        List<Invoice> invoiceList = invoiceEntityService.findByTotalPriceGreaterThanEqual(price);

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Invoice invoice : invoiceList) {
            totalPrice = totalPrice.add(invoice.getTotalPrice());
        }

        BigDecimal averagePrice = totalPrice.divide(BigDecimal.valueOf(invoiceList.size()));

        AveragePriceDto averagePriceDto = new AveragePriceDto();

        averagePriceDto.setAveragePrice(averagePrice);

        return averagePriceDto;
    }

    public TotalPriceFromCustomerRegistrationDateDto getTotalPriceFromCustomerRegistrationDate(int month) {

        List<Customer> customerList = customerService.findByDateOfRegistrationMonth(month);

        List<Long> customerIds = customerList.stream().map(Customer::getId).collect(Collectors.toList());

        List<Invoice> invoiceList = invoiceEntityService.findByCustomerIds(customerIds);

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Invoice invoice : invoiceList) {
            totalPrice = totalPrice.add(invoice.getTotalPrice());
        }

        TotalPriceFromCustomerRegistrationDateDto totalPriceFromCustomerRegistrationDateDto = new TotalPriceFromCustomerRegistrationDateDto();
        totalPriceFromCustomerRegistrationDateDto.setTotalPrice(totalPrice);

        return totalPriceFromCustomerRegistrationDateDto;
    }

}
