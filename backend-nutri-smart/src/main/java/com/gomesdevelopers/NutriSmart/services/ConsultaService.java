package com.gomesdevelopers.NutriSmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomesdevelopers.NutriSmart.dto.ConsultaDTO;
import com.gomesdevelopers.NutriSmart.entities.Consulta;
import com.gomesdevelopers.NutriSmart.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Transactional
	public ConsultaDTO salvarConsulta(ConsultaDTO consultaDTO) {
		Consulta consulta = 
	}
}
