package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;

import com.gomesdevelopers.NutriSmart.entities.Cliente;

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

    private Long nutricionistaId;
    
    public ClienteDTO() {
    }
    
    

    public ClienteDTO(Long id, String cpf, String nome, LocalDate dataNascimento, String sexo, String telefone,
			String email, String endereco, LocalDate dataRegistro, Long nutricionistaId) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.dataRegistro = dataRegistro;
		this.nutricionistaId = nutricionistaId;
	}



	public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        cpf = cliente.getCpf();
        nome = cliente.getNome();
        dataNascimento = cliente.getDataNascimento();
        sexo = cliente.getSexo();
        telefone = cliente.getTelefone();
        email = cliente.getEmail();
        endereco = cliente.getEndereco();
        dataRegistro = cliente.getDataRegistro();
        nutricionistaId = cliente.getNutricionista() != null ? cliente.getNutricionista().getId() : null;
    }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public LocalDate getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
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



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public LocalDate getDataRegistro() {
		return dataRegistro;
	}



	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}



	public Long getNutricionistaId() {
		return nutricionistaId;
	}



	public void setNutricionistaId(Long nutricionistaId) {
		this.nutricionistaId = nutricionistaId;
	}
	


}
