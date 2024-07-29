package com.gomesdevelopers.NutriSmart.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.dto.NutricionistaDTO;
import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.entities.Nutricionista;
import com.gomesdevelopers.NutriSmart.repositories.NutricionistaRepository;

@Service
public class NutricionistaService {

    @Autowired
    private NutricionistaRepository repository;

    private Nutricionista convertToEntity(NutricionistaDTO nutricionistaDTO){
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setId(nutricionistaDTO.getId());
        nutricionista.setEmail(nutricionistaDTO.getEmail());
        nutricionista.setCrn(nutricionistaDTO.getCrn());
        nutricionista.setNome(nutricionistaDTO.getNome());
        nutricionista.setTelefone(nutricionistaDTO.getTelefone());
        nutricionista.setDataContratacao(nutricionistaDTO.getDataContratacao());
        nutricionista.setEspecialidade(nutricionistaDTO.getEspecialidade());

        return nutricionista;
    }
    
    private NutricionistaDTO convertToDTO(Nutricionista nutricionista) {
    	NutricionistaDTO nutricionistaDTO = new NutricionistaDTO();
    	nutricionistaDTO.setId(nutricionista.getId());
    	nutricionistaDTO.setEmail(nutricionista.getEmail());
    	nutricionistaDTO.setCrn(nutricionista.getCrn());
    	nutricionistaDTO.setNome(nutricionista.getNome());
    	nutricionistaDTO.setTelefone(nutricionista.getTelefone());
    	nutricionistaDTO.setDataContratacao(nutricionista.getDataContratacao());
    	nutricionistaDTO.setEspecialidade(nutricionista.getEspecialidade());
    	
    	return nutricionistaDTO;
    }

    public NutricionistaDTO salvarNutricionista(NutricionistaDTO nutricionistaDTO){
        Nutricionista nutricionista = convertToEntity(nutricionistaDTO);
        Nutricionista savedNutricionista =  repository.save(nutricionista);
        return new NutricionistaDTO(savedNutricionista);

    }
    

    public NutricionistaDTO buscarNutricionistaPorId(Long id){
        Nutricionista nutricionista = repository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado!"));
        return convertToDTO(nutricionista);
    }
    
    public List<NutricionistaDTO> listarNutricionista(){
    	return repository.findAll().stream().map(this:: convertToDTO).collect(Collectors.toList());
    }
    
    public void deletarNutricionista(Long id) {
    	repository.deleteById(id);
    }
    
    public NutricionistaDTO atualizarNutricionista (Long id, NutricionistaDTO nutricionistaDTO) {
    	Nutricionista nutricionistaExistente = repository.findById(id)
    			.orElseThrow( () -> new RuntimeException("Nutricionista não encontrado"));
    	
    	nutricionistaExistente.setCrn(nutricionistaDTO.getCrn());
    	nutricionistaExistente.setDataContratacao(nutricionistaDTO.getDataContratacao());
    	nutricionistaExistente.setEmail(nutricionistaDTO.getEmail());
    	nutricionistaExistente.setEspecialidade(nutricionistaDTO.getEspecialidade());
    	nutricionistaExistente.setNome(nutricionistaDTO.getNome());
    	nutricionistaExistente.setTelefone(nutricionistaDTO.getTelefone());
    	
    	Nutricionista nutricionistaAtualizado = repository.save(nutricionistaExistente);
    	
    	return  new NutricionistaDTO(nutricionistaAtualizado);

    }
}
