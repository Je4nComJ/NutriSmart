package com.gomesdevelopers.NutriSmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesdevelopers.NutriSmart.dto.ConsultaDTO;
import com.gomesdevelopers.NutriSmart.entities.Consulta;
import com.gomesdevelopers.NutriSmart.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	private void dtoToEntity(ConsultaDTO dto, Consulta entity) {
		entity.setCliente(dto.getClienteDTO().getId());
		entity.setDataConsulta(dto.getDataConsulta());
		entity.setNutricionista(dto.getNutricionista());
		entity.setObservacoes(dto.getObservacoes());
	}
}
