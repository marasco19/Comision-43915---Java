package com.coderhouse.Clase8JPAABM.repository;


import com.coderhouse.Clase8JPAABM.model.InvoiceDTO;
import com.coderhouse.Clase8JPAABM.model.InvoiceDetail;
import com.coderhouse.Clase8JPAABM.model.InvoiceDetailDTE;
import com.coderhouse.Clase8JPAABM.model.InvoiceDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
    @Query("SELECT new com.coderhouse.Clase8JPAABM.model.InvoiceDetailDTO(" +
            "p.title, " +
            "p.description, " +
            "p.code, " +
            "d.price, " +
            "d.quantity" +
            ") FROM Invoice i JOIN i.invoiceDetails d JOIN d.product p WHERE i.id = :id")
    List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(@Param("id") int invoice_id);
}
