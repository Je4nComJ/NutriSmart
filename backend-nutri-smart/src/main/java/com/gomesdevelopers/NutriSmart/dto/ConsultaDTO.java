package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;

import com.gomesdevelopers.NutriSmart.entities.Consulta;

import lombok.Data;

@Data
public class ConsultaDTO {
	
    private Long id;
    private ClienteDTO cliente;
    private NutricionistaDTO nutricionista;
    private LocalDate dataConsulta;
    private String observacoes;
    
    public ConsultaDTO() {}
    
    public ConsultaDTO(Consulta entity) {
    	id = entity.getId();
    	cliente =  new ClienteDTO(entity.getCliente());
    	nutricionista = new NutricionistaDTO(entity.getNutricionista());
    	dataConsulta = entity.getDataConsulta();
    	observacoes = entity.getObservacoes();
    }
}
