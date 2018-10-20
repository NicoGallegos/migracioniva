package com.iva.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iva.model.Compras;

public interface ComprasRepository extends CrudRepository<Compras, Integer> {

	List<Compras> findByMesano(@Param("mesano") Integer mesano);

}
