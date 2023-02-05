package com.kaancaki.orderapp.dao;

import java.math.BigDecimal;
import java.util.List;

import com.kaancaki.orderapp.entity.Customer;
import com.kaancaki.orderapp.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice,Long> {
    @Query("select i from Invoice i where i.customerId in :ids")
    List<Invoice> findByCustomerIds(@Param("ids") List<Long> customerIds);

    List<Invoice> findByTotalPriceGreaterThanEqual(BigDecimal price);

    List<Invoice> findByTotalPriceLessThanEqual(BigDecimal price);

    @Query("SELECT i FROM Invoice i WHERE month(i.invoiceCreatedDate) = :month and i.companyId = :companyId")
    public List<Invoice> findByInvoiceCreatedMonthAndCompanyId(@Param("month") int month, @Param("companyId") Long companyId);

}
