package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.Idioma;

public interface IIdiomaService {

	public void save(Idioma idioma);//guardar -> create/update 
	public Optional <Idioma> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<Idioma> findAll();//consultar en conjunto -> List
}
