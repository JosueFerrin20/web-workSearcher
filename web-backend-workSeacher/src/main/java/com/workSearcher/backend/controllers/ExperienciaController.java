package com.workSearcher.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workSearcher.backend.models.entities.Experiencia;

import com.workSearcher.backend.models.services.interfaces.IExperienciaService;

@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

	@Autowired
	IExperienciaService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Experiencia e ) {
		try {
			service.save(e);
			return ResponseEntity.status(HttpStatus.CREATED).body(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Experiencia> e = service.findById(id);
			if(e.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiencia no encontrada");
			}
			return ResponseEntity.ok(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Experiencia e) {
		try {
			e.setIdExperiencia(id);
			service.save(e);
			return ResponseEntity.ok(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Experiencia> e = service.findById(id);
			if(e.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiencia no encontrada");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Experiencia> experiencias = service.findAll();
			if(experiencias.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Experiencias registradas");
			}
			return ResponseEntity.ok(experiencias);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
