package com.kaancaki.orderapp.service.impl;

import com.kaancaki.orderapp.converter.InvoiceMapper;
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
