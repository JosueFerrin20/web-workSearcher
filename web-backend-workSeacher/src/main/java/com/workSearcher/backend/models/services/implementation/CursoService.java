package com.workSearcher.backend.models.services.implementation;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workSearcher.backend.models.entities.Curso;
import com.workSearcher.backend.models.repositories.ICurso;
import com.workSearcher.backend.models.services.interfaces.ICursoService;

@Service
public class CursoService implements ICursoService{

	@Autowired
	private ICurso repository;
	
	@Override
	@Transactional
	public void save(Curso curso) {
		// TODO Auto-generated method stub
		repository.save(curso);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Curso> findById(Integer id) {
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
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return (List<Curso>) repository.findAll();
	}
}

