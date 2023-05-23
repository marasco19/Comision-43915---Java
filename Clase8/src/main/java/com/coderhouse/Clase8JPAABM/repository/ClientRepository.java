package com.coderhouse.Clase8JPAABM.repository;

import com.coderhouse.Clase8JPAABM.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}