package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.ofertaEmpleo;

public interface IOfertaEmpleoService {
	
	public void save(ofertaEmpleo oferta);//guardar -> create/update 
	public Optional <ofertaEmpleo> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<ofertaEmpleo> findAll();//consultar en conjunto -> List
}
