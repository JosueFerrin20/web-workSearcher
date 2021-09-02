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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workSearcher.backend.models.entities.Aspirante;

import com.workSearcher.backend.models.services.interfaces.IAspiranteService;

@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/aspirante")
public class AspiranteController {

	@Autowired
	IAspiranteService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Aspirante a ) {
		try {
			service.save(a);
			return ResponseEntity.status(HttpStatus.CREATED).body(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
		@GetMapping("/retrieve/{id}")
		public ResponseEntity<?> retrieve(@PathVariable Integer id) {
			try {
				Optional<Aspirante> a = service.findById(id);
				if(a.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aspirante no encontrado");
				}
				return ResponseEntity.ok(a);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}		
		}
		
		//Update
//		@PutMapping("/update/{id}")
//		public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Aspirante a) {
//			try {
//				a.setId(id);
//				service.save(a);
//				return ResponseEntity.ok(a);
//			}
//			catch(Exception ex) {
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
//			}
//		}
		
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> update(@PathVariable Integer id) {
			try {
				Optional<Aspirante> a = service.findById(id);
				if(a.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aspirante no encontrado");
				}
				service.delete(id);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}
		
		@GetMapping("/list")
		public ResponseEntity<?> list() {
			try {
				List<Aspirante> aspirantes = service.findAll();
				if(aspirantes.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Aspirantees registrados");
				}
				return ResponseEntity.ok(aspirantes);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}		
		}
}
