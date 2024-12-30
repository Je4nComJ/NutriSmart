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
public class ClienteDTO {
	
	private Long id;

	private String cpf;

	private String nome;

	private LocalDate dataNascimento;

	private String sexo;

	private String telefone;

	private String email;

	private String endereco;

	private LocalDate dataRegistro;

	private List<NutricionistaDTO> nutricionistas = new ArrayList<>();

	private List<ConsultaDTO> consultas = new ArrayList<>();
	
	public ClienteDTO() {}
	
	public ClienteDTO(Cliente entity) {
		id = entity.getId();
		cpf = entity.getCpf();
		nome = entity.getNome();
		dataNascimento = entity.getDataNascimento();
		sexo = entity.getSexo();
		telefone = entity.getTelefone();
		email = entity.getEmail();
		endereco = entity.getEndereco();
		dataRegistro = entity.getDataRegistro();
	}
	
	public ClienteDTO(Cliente entity, Set<Nutricionista> nutricionistas, Set<Consulta> consultas) {
		this(entity);
		
		nutricionistas.forEach(nutri -> this.nutricionistas.add(new NutricionistaDTO(nutri)));
		
		consultas.forEach(cons -> this.consultas.add(new ConsultaDTO(cons)));		
	}
}

