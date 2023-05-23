package com.coderhouse.Clase8JPAABM.repository;

import com.coderhouse.Clase8JPAABM.model.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {
}
