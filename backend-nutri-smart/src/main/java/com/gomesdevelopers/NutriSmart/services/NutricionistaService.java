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
public class NutricionistaService {
	
	@Autowired
	private NutricionistaRepository repository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public Page<NutricionistaDTO> findAllPaged(Pageable pageable){
		Page<Nutricionista> list = repository.findAll(pageable);
		return list.map(x -> new NutricionistaDTO(x));
	}
	
	@Transactional(readOnly = true)
	public NutricionistaDTO findById (Long id) {
		Nutricionista entity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Nutricionista com o ID: " + id + " não encontrado!"));
		return new NutricionistaDTO(entity);
	}
	
	@Transactional
	public NutricionistaDTO insert(NutricionistaDTO dto) {
		Nutricionista entity = new Nutricionista();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new NutricionistaDTO(entity);
	}
	
	@Transactional
	public NutricionistaDTO update(Long id, NutricionistaDTO dto) {
		Nutricionista entity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Nutricionista com o ID: " + id + " não encontrado!"));
		
		dtoToEntity(dto, entity);
		Nutricionista savedNutri = repository.save(entity);
		
		return new NutricionistaDTO(savedNutri);
	}
	
	@Transactional
	public void delete(Long id) {
		try {
		repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Nutricionista com id: " + id + " não encontrado em nossa base de dados"));	
		repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível deletar, entidade em conflito!");
		}
	}
	
	
	private void dtoToEntity(NutricionistaDTO dto, Nutricionista entity) {
		entity.setCrn(dto.getCrn());
		entity.setDataContratacao(dto.getDataContratacao());
		entity.setEmail(dto.getEmail());
		entity.setEspecialidade(dto.getEspecialidade());
		entity.setNome(dto.getNome());
		entity.setTelefone(dto.getTelefone());
		
		entity.getClientes().clear();
		for(ClienteDTO cliDTO : dto.getClientes()) {
			Cliente cliente = clienteRepository.getReferenceById(cliDTO.getId());
			entity.getClientes().add(cliente);
		}
		
		entity.getConsultas().clear();
		for(ConsultaDTO consDTO : dto.getConsultas()) {
			Consulta consulta = consultaRepository.getReferenceById(consDTO.getId());
			entity.getConsultas().add(consulta);
		}
	}
}
