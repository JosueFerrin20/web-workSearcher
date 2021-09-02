package com.workSearcher.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.workSearcher.backend.models.entities.Empresa;

public interface IEmpresa extends CrudRepository<Empresa,Integer>{

}
