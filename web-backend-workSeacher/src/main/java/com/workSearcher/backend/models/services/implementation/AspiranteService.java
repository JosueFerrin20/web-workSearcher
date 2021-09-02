package com.workSearcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workSearcher.backend.models.entities.Aspirante;
import com.workSearcher.backend.models.repositories.IAspirante;
import com.workSearcher.backend.models.services.interfaces.IAspiranteService;

@Service
public class AspiranteService implements IAspiranteService{

	//Sirve para implementar los metodos de gestion, inyectanto el DAO
	@Autowired
	private IAspirante repository;//<= DAO Data Access Object, sirve para realizar las operaciones de Gestión 
	//El Service sirve para implementar los metodos de Gestión, es como un envoltorio para el repositorio
	
	
	@Override
	@Transactional
	public void save(Aspirante aspirante) {
		// TODO Auto-generated method stub
		repository.save(aspirante);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Aspirante> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Aspirante> findAll() {
		// TODO Auto-generated method stub
		return (List<Aspirante>) repository.findAll();
	}
	
}
