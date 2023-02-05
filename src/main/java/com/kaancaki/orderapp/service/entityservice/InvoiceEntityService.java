package com.kaancaki.orderapp.service.entityservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import com.kaancaki.orderapp.dao.InvoiceDao;
import com.kaancaki.orderapp.entity.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceEntityService {
    private final InvoiceDao invoiceDao;

    public Invoice save(Invoice invoice) {
        invoice.setInvoiceCreatedDate(LocalDate.now());

        return invoiceDao.save(invoice);
    }
    public Invoice findById(Long id) {
        Optional<Invoice> invoice = invoiceDao.findById(id);

        if (!invoice.isPresent()) {
            throw new RuntimeException();
        }

        return invoice.get();
    }

    public List<Invoice> findAll() {
        return invoiceDao.findAll();
    }

    public List<Invoice> findByCustomerIds(List<Long> customerIds) {
        return invoiceDao.findByCustomerIds(customerIds);
    }

    public List<Invoice> findByTotalPriceGreaterThanEqual(BigDecimal price) {
        return invoiceDao.findByTotalPriceGreaterThanEqual(price);
    }

    public List<Invoice> findByTotalPriceLessThanEqual(BigDecimal price) {
        return invoiceDao.findByTotalPriceLessThanEqual(price);
    }

    public List<Invoice> findByInvoiceCreatedMonthAndCompanyId(int month, Long companyId) {
        return invoiceDao.findByInvoiceCreatedMonthAndCompanyId(month, companyId);
    }

}
