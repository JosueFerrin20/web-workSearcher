package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.Trabajador;

public interface ITrabajadorService {
	
	public void save(Trabajador trabajador);//guardar -> create/update 
	public Optional <Trabajador> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<Trabajador> findAll();//consultar en conjunto -> List
	Optional<Trabajador> findByNombre(String nombre);

}
