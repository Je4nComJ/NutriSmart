package com.gomesdevelopers.NutriSmart.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findAllPaged(Pageable pageable){
		Page<ClienteDTO> dto = service.findAllPaged(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
		ClienteDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert (@RequestBody ClienteDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}

