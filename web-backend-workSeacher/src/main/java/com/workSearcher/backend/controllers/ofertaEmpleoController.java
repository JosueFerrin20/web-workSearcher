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

import com.workSearcher.backend.models.entities.ofertaEmpleo;

import com.workSearcher.backend.models.services.interfaces.IOfertaEmpleoService;

@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/ofertaEmpleo")
public class ofertaEmpleoController {

	@Autowired
	IOfertaEmpleoService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ofertaEmpleo o ) {
		try {
			service.save(o);
			return ResponseEntity.status(HttpStatus.CREATED).body(o);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<ofertaEmpleo> o = service.findById(id);
			if(o.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta de Empleo no encontrada");
			}
			return ResponseEntity.ok(o);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ofertaEmpleo o) {
		try {
			o.setIdOfertaEmpleo(id);
			service.save(o);
			return ResponseEntity.ok(o);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<ofertaEmpleo> o = service.findById(id);
			if(o.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta de Empleo no encontrada");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(o);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<ofertaEmpleo> ofertas = service.findAll();
			if(ofertas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Ofertas de Empleos registradas");
			}
			return ResponseEntity.ok(ofertas);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
