package com.workSearcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workSearcher.backend.models.entities.Idioma;
import com.workSearcher.backend.models.repositories.IIdioma;
import com.workSearcher.backend.models.services.interfaces.IIdiomaService;

@Service
public class IdiomaService implements IIdiomaService{
	@Autowired
	private IIdioma repository;

	@Override
	@Transactional
	public void save(Idioma idioma) {
		// TODO Auto-generated method stub
		repository.save(idioma);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Idioma> findById(Integer id) {
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
	public List<Idioma> findAll() {
		// TODO Auto-generated method stub
		return (List<Idioma>) repository.findAll();
	}
}
