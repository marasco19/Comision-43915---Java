package com.coderhouse.Clase8JPAABM.repository;

import com.coderhouse.Clase8JPAABM.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ClientRepository extends JpaRepository<Client, Integer> {
    //Custom query by method name
    List<Client> findByNameLike(String name);
    //Custom query by JPQL query
    @Query("SELECT a FROM Client a WHERE name = :nombre ORDER BY lastname ASC")
    List<Client> getByNameOrderedByLastnameJPQL(@Param("nombre") String name);
    //Si no se especifica el parametro nativeQuery por default se utiliza JPQL
    @Query(value = "SELECT * FROM client a WHERE name = ?1 ORDER BY lastname ASC", nativeQuery = true)
    List<Client> getByNameOrderedByLastnameNativeQuery(String name);
    //Difiere JPQL de SQL normal, simplemente llamamos a INNER JOIN pero no especificamos las claves
    @Query("SELECT c, i FROM Client c INNER JOIN c.invoice i WHERE c.id= :id")
    List<Client> getInvoicesWithClientById(@Param("id") int id);

}