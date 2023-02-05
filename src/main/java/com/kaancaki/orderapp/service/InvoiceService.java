package com.kaancaki.orderapp.service;

import com.kaancaki.orderapp.dto.InvoiceDto;
import com.kaancaki.orderapp.entity.Invoice;

public interface InvoiceService {

    Invoice save(InvoiceDto invoiceDto);
}
