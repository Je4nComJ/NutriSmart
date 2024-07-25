package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;

import com.gomesdevelopers.NutriSmart.entities.Nutricionista;

public class NutricionistaDTO {

    private Long id;
    private String nome;
    private String crn;
    private String telefone;
    private String email;
    private String especialidade;
    private LocalDate dataContratacao;
    
    public NutricionistaDTO() {
    }

    public NutricionistaDTO(Long id, String nome, String crn, String telefone, String email, String especialidade,
			LocalDate dataContratacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.crn = crn;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
		this.dataContratacao = dataContratacao;
	}

	public NutricionistaDTO(Nutricionista nutricionista){
        this.id = nutricionista.getId();
        this.nome = nutricionista.getNome();
        this.crn = nutricionista.getCrn();
        this.telefone = nutricionista.getTelefone();
        this.email = nutricionista.getEmail();
        this.especialidade = nutricionista.getEspecialidade();
        this.dataContratacao = nutricionista.getDataContratacao();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}


}
