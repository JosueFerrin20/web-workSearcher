package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.Experiencia;

public interface IExperienciaService {

	public void save(Experiencia experiencia);//guardar -> create/update 
	public Optional <Experiencia> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<Experiencia> findAll();//consultar en conjunto -> List
}
