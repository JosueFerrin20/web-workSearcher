package com.workSearcher.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.workSearcher.backend.models.entities.Curso;

public interface ICurso extends CrudRepository<Curso,Integer>{

}
