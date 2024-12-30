package com.gomesdevelopers.NutriSmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.dto.ConsultaDTO;
import com.gomesdevelopers.NutriSmart.dto.NutricionistaDTO;
import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.entities.Consulta;
import com.gomesdevelopers.NutriSmart.entities.Nutricionista;
import com.gomesdevelopers.NutriSmart.exceptions.EntityNotFoundException;
import com.gomesdevelopers.NutriSmart.repositories.ClienteRepository;
import com.gomesdevelopers.NutriSmart.repositories.ConsultaRepository;
import com.gomesdevelopers.NutriSmart.repositories.NutricionistaRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPaged(Pageable pageable){
		Page<Cliente> list = repository.findAll(pageable);
		return list.map(x -> new ClienteDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Cliente entity = repository.findById(id).orElseThrow(
				() ->new EntityNotFoundException("Cliente com id: " + id + " não encontrado em nossa base de dados"));
		
		return new ClienteDTO(entity);
		
	}
	
	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClienteDTO(entity);
	}
	
	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		Cliente entity = repository.findById(id).orElseThrow(
				() ->new EntityNotFoundException("Cliente com id: " + id + " não encontrado em nossa base de dados"));
		
		dtoToEntity(dto, entity);
		Cliente savedCliente = repository.save(entity);
		return new ClienteDTO(savedCliente);
	}
	
	@Transactional
	public void delete(Long id) {
		try {
		repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Cliente com id: " + id + " não encontrado em nossa base de dados"));	
		repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível deletar, entidade em conflito!");
		}
	}
	
	private void dtoToEntity(ClienteDTO dto, Cliente entity) {
		entity.setCpf(dto.getCpf());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setDataRegistro(dto.getDataRegistro());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());
		entity.setNome(dto.getNome());
		entity.setSexo(dto.getSexo());
		entity.setTelefone(dto.getTelefone());
		
		entity.getNutricionistas().clear();
		for(NutricionistaDTO nutDTO : dto.getNutricionistas()) {
			Nutricionista nutricionista = nutricionistaRepository.getReferenceById(nutDTO.getId());
			entity.getNutricionistas().add(nutricionista);
		}
		
		entity.getConsultas().clear();
		for(ConsultaDTO consDTO : dto.getConsultas()) {
			Consulta consulta = consultaRepository.getReferenceById(consDTO.getId());
			entity.getConsultas().add(consulta);
		}
	}
}
