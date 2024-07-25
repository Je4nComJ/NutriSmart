package com.gomesdevelopers.NutriSmart.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_nutricionista")
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "crn", nullable = false, unique = true)
    private String crn;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @Column(name = "data_contratacao", nullable = false)
    private LocalDate dataContratacao;

    @OneToMany(mappedBy = "nutricionista")
    Set<Cliente> clientes = new HashSet<>();

    @OneToMany(mappedBy = "nutricionista")
    private Set<Consulta> consultas = new HashSet<>();
    
    public Nutricionista() {}

	public Nutricionista(Long id, String nome, String crn, String telefone, String email, String especialidade,
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

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public Set<Consulta> getConsultas() {
		return consultas;
	}

}
