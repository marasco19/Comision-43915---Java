package com.coderhouse.Clase8JPAABM.repository;

import com.coderhouse.Clase8JPAABM.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ClientRepository extends JpaRepository<Client, Integer> {

}