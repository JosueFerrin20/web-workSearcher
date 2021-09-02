package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.Empresa;

public interface IEmpresaService {
	public void save(Empresa entidad);//guardar -> create/update 
	public Optional <Empresa> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<Empresa> findAll();//consultar en conjunto -> List
}
