package com.workSearcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workSearcher.backend.models.entities.Trabajador;
import com.workSearcher.backend.models.repositories.ITrabajador;

import com.workSearcher.backend.models.services.interfaces.ITrabajadorService;

@Service
public class TrabajadorService implements ITrabajadorService{
	
	@Autowired
	private ITrabajador repository;

	@Override
	@Transactional
	public void save(Trabajador trabajador) {
		// TODO Auto-generated method stub
		repository.save(trabajador);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Trabajador> findById(Integer id) {
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
	public List<Trabajador> findAll() {
		// TODO Auto-generated method stub
		return (List<Trabajador>) repository.findAll();
	}
	
	@Override
	@Transactional
	public Optional<Trabajador> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.findByNombre(nombre);
	}

}
