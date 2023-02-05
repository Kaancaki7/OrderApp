package com.kaancaki.orderapp.converter;

import com.kaancaki.orderapp.dto.InvoiceDto;
import com.kaancaki.orderapp.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    InvoiceDto invoiceToInvoiceDto(Invoice invoice);

    Invoice invoiceDtoToInvoice(InvoiceDto invoiceDto);

}
