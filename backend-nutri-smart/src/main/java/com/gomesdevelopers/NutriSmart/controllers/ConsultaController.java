package com.gomesdevelopers.NutriSmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomesdevelopers.NutriSmart.dto.ConsultaDTO;
import com.gomesdevelopers.NutriSmart.services.ConsultaService;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public ResponseEntity<Page<ConsultaDTO>> findAllPaged(Pageable pageable){
		Page<ConsultaDTO> dto = service.findAllPaged(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConsultaDTO> findById(@PathVariable Long id){
		ConsultaDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ConsultaDTO> insert (@RequestBody ConsultaDTO dto){
		dto = service.insert(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ConsultaDTO> update(@PathVariable Long id, @RequestBody ConsultaDTO dto){
		dto = service.update(id, dto);
		
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
