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

import com.workSearcher.backend.models.entities.Idioma;

import com.workSearcher.backend.models.services.interfaces.IIdiomaService;

@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/idioma")
public class IdiomaController {

	@Autowired
	IIdiomaService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Idioma i ) {
		try {
			service.save(i);
			return ResponseEntity.status(HttpStatus.CREATED).body(i);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Idioma> i = service.findById(id);
			if(i.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Idioma no encontrado");
			}
			return ResponseEntity.ok(i);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Idioma i) {
		try {
			i.setIdIdioma(id);
			service.save(i);
			return ResponseEntity.ok(i);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Idioma> i = service.findById(id);
			if(i.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Idioma no encontrado");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(i);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Idioma> idiomas = service.findAll();
			if(idiomas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Idiomas registrados");
			}
			return ResponseEntity.ok(idiomas);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
