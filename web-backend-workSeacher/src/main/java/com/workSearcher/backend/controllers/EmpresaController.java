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

import com.workSearcher.backend.models.entities.Empresa;

import com.workSearcher.backend.models.services.interfaces.IEmpresaService;

@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	IEmpresaService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Empresa e ) {
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
			Optional<Empresa> e = service.findById(id);
			if(e.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada");
			}
			return ResponseEntity.ok(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Empresa e) {
		try {
			e.setIdEmpresa(id);
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
			Optional<Empresa> e = service.findById(id);
			if(e.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada");
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
			List<Empresa> empresas = service.findAll();
			if(empresas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Empresas registradas");
			}
			return ResponseEntity.ok(empresas);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
