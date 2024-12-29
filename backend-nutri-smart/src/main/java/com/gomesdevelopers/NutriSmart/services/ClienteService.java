package com.gomesdevelopers.NutriSmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.exceptions.EntityNotFoundException;
import com.gomesdevelopers.NutriSmart.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPaged(Pageable pageable){
		Page<Cliente> list = repository.findAll(pageable);
		return list.map(x -> new ClienteDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Cliente entity = repository.findById(id).orElseThrow(() ->new EntityNotFoundException("Cliente com id: " + id + " não encontrado em nossa base de dados"));
		
		return new ClienteDTO(entity);
		
	}
}
