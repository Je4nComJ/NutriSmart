package com.gomesdevelopers.NutriSmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	public Page<ConsultaDTO> findAllPaged(Pageable pageable) {
		
		Page<Consulta> list =repository.findAll(pageable);
		return list.map(x -> new ConsultaDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ConsultaDTO findById(Long id) {
		Consulta entity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Não foi possível encontrar a Consulta de id: " + id));
		
		return new ConsultaDTO(entity);
	}
	
	@Transactional
	public ConsultaDTO insert(ConsultaDTO dto) {
		Consulta entity = new Consulta();
		dtoToEntity(dto,entity);
		entity = repository.save(entity);
		return new ConsultaDTO(entity);
	}
	
	@Transactional
	public ConsultaDTO update (Long id, ConsultaDTO dto) {
		Consulta entity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Não foi possível encontrar a consulta de ID: " + id));
		dtoToEntity(dto,entity);
		Consulta savedConsulta = repository.save(entity);
		return new ConsultaDTO(savedConsulta);
	}
	
	@Transactional
	public void delete(Long id) {
		try {
		repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Consulta com ID: " + id + " não encontrada em nossa base de dados"));	
		repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível deletar, entidade em conflito!");
		}
	}
	
	private void dtoToEntity(ConsultaDTO dto, Consulta entity) {
		entity.setDataConsulta(dto.getDataConsulta());

		entity.setObservacoes(dto.getObservacoes());
		
		Cliente cliente = clienteRepository.findById(dto.getCliente().getId()).orElseThrow(
				() -> new EntityNotFoundException("Cliente com o id: " + dto.getCliente().getId() + " não encontrado!"));
		entity.setCliente(cliente);
		
		Nutricionista nutricionista = nutricionistaRepository.findById(dto.getNutricionista().getId()).orElseThrow(
				() -> new EntityNotFoundException("Nutricionista com o id: " + dto.getNutricionista().getId() + " não encontrado!"));
		entity.setNutricionista(nutricionista);
	}
}
