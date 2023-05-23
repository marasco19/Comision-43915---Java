package com.coderhouse.Clase8JPAABM.repository;

import com.coderhouse.Clase8JPAABM.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
