package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    private Set<Cliente> clientes = new HashSet<>();

    private Set<Consulta> consultas = new HashSet<>();
    
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
    	clientes.stream().map(cli -> new ClienteDTO(cli)).collect(Collectors.toSet());
    	consultas.stream().map(cons -> new ConsultaDTO(cons)).collect(Collectors.toSet());
    	
    }
}
