package com.iva.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iva.model.Ventas;

public interface VentasRepository extends CrudRepository<Ventas, Integer> {

	//@Query"(select p from Person p where p.forename = :forename and p.surname = :surname)
	List<Ventas> findByMesano(@Param("mesano") Integer mesano);
}
