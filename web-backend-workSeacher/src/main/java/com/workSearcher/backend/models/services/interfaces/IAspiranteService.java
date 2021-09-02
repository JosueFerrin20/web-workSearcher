package com.workSearcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.workSearcher.backend.models.entities.Aspirante;

public interface IAspiranteService {
	
		// La interface de servicio, sirve para definir el conjunto de metodos que 
		//se van a implementar para la Gestion del modelo-entidad 
			
		public void save(Aspirante aspirante);//guardar -> create/update 
		public Optional <Aspirante> findById(Integer id);//consultar -> retrieve
		public void delete(Integer id);//Borrar -> delete
		public List<Aspirante> findAll();//consultar en conjunto -> List
}
