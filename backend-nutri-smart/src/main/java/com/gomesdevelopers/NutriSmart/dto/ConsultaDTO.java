package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;

import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.entities.Consulta;
import com.gomesdevelopers.NutriSmart.entities.Nutricionista;

import lombok.Data;

@Data
public class ConsultaDTO {
	
    private Long id;
    private Cliente cliente;
    private Nutricionista nutricionista;
    private LocalDate dataConsulta;
    private String observacoes;
    
    public ConsultaDTO(Consulta entity) {
    	id = entity.getId();
    	cliente = entity.getCliente();
    	nutricionista = entity.getNutricionista();
    	dataConsulta = entity.getDataConsulta();
    	observacoes = entity.getObservacoes();
    }
}
