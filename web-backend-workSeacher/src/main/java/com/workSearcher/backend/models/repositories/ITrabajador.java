package com.workSearcher.backend.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.workSearcher.backend.models.entities.Trabajador;

public interface ITrabajador extends CrudRepository<Trabajador,Integer> {
	// se ha agragado una definicion de método
//	sintaxis: public Optional<Clase> findByAtributoDeLaClase(String nombre);
	public Optional<Trabajador> findByNombre(String nombre);

}
