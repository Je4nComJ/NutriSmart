package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.entities.Consulta;
import com.gomesdevelopers.NutriSmart.entities.Nutricionista;

import lombok.Data;

@Data
public class NutricionistaDTO {
	
    private Long id;
 
    private String nome;

    private String crn;

    private String telefone;

    private String email;

    private String especialidade;
 
    private LocalDate dataContratacao;

    private List<ClienteDTO> clientes = new ArrayList<>();

    private List<ConsultaDTO> consultas = new ArrayList<>();
   
    public NutricionistaDTO() {}
    
    public NutricionistaDTO(Nutricionista entity) {
    	id = entity.getId();
    	nome = entity.getNome();
    	crn = entity.getCrn();
    	telefone = entity.getTelefone();
    	email = entity.getEmail();
    	especialidade = entity.getEspecialidade();
    	dataContratacao = entity.getDataContratacao();
    }
    
    public NutricionistaDTO(Nutricionista entity, Set<Cliente> clientes, Set<Consulta> consultas) {
    	this(entity);
    	
    	clientes.forEach(cli -> this.clientes.add(new ClienteDTO(cli)));
    	
    	consultas.forEach(cons -> this.consultas.add(new ConsultaDTO(cons)));
    	
    }
}
