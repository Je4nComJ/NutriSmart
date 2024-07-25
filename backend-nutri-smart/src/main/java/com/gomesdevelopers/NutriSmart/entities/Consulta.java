package com.gomesdevelopers.NutriSmart.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_nutricionista", nullable = false)
    private Nutricionista nutricionista;

    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    @Column(name = "observações")
    private String observacoes;
    
    public Consulta() {}

	public Consulta(Long id, Cliente cliente, Nutricionista nutricionista, LocalDate dataConsulta, String observacoes) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.nutricionista = nutricionista;
		this.dataConsulta = dataConsulta;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
    
    

}
