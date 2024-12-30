package com.gomesdevelopers.NutriSmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesdevelopers.NutriSmart.dto.ConsultaDTO;
import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.entities.Consulta;
import com.gomesdevelopers.NutriSmart.entities.Nutricionista;
import com.gomesdevelopers.NutriSmart.exceptions.EntityNotFoundException;
import com.gomesdevelopers.NutriSmart.repositories.ClienteRepository;
import com.gomesdevelopers.NutriSmart.repositories.ConsultaRepository;
import com.gomesdevelopers.NutriSmart.repositories.NutricionistaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	private void dtoToEntity(ConsultaDTO dto, Consulta entity) {
		entity.setDataConsulta(dto.getDataConsulta());

		entity.setObservacoes(dto.getObservacoes());
		
		Cliente cliente = clienteRepository.findById(dto.getClienteDTO().getId()).orElseThrow(
				() -> new EntityNotFoundException("Cliente com o id: " + dto.getClienteDTO().getId() + " não encontrado!"));
		entity.setCliente(cliente);
		
		Nutricionista nutricionista = nutricionistaRepository.findById(dto.getNutricionistaDTO().getId()).orElseThrow(
				() -> new EntityNotFoundException("Nutricionista com o id: " + dto.getNutricionistaDTO().getId() + " não encontrado!"));
		entity.setNutricionista(nutricionista);
	}
}
