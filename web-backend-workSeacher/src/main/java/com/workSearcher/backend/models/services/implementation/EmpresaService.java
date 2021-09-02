package com.workSearcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workSearcher.backend.models.entities.Empresa;
import com.workSearcher.backend.models.repositories.IEmpresa;
import com.workSearcher.backend.models.services.interfaces.IEmpresaService;
@Service
public class EmpresaService implements IEmpresaService {
	@Autowired
	private IEmpresa repository;
	
	@Override
	@Transactional
	public void save(Empresa empresa) {
		// TODO Auto-generated method stub
		repository.save(empresa);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Empresa> findById(Integer id) {
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
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return (List<Empresa>) repository.findAll();
	}
}

