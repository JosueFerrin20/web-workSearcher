package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.Curso;

public interface ICursoService {

	public void save(Curso curso);//guardar -> create/update 
	public Optional <Curso> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<Curso> findAll();//consultar en conjunto -> List
}
