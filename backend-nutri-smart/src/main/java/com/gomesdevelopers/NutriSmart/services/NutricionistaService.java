package com.gomesdevelopers.NutriSmart.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesdevelopers.NutriSmart.dto.NutricionistaDTO;
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
    
    public List<NutricionistaDTO> listarNutricionista(){
    	return repository.findAll().stream().map(this:: convertToDTO).collect(Collectors.toList());
    }
    
    public void deletarNutricionista(Long id) {
    	repository.deleteById(id);
    }
}
