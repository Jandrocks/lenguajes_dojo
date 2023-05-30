package com.alemeza.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alemeza.lenguajes.models.LenguajeModelo;

@Repository
public interface LenguajeRepo extends CrudRepository<LenguajeModelo, Long>{
	
	//Este método recupera todos los lenguajes de la base de datos
	List<LenguajeModelo> findAll();
		
	
}
