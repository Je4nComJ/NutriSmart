package com.gomesdevelopers.NutriSmart.dto;

import java.time.LocalDate;

import com.gomesdevelopers.NutriSmart.entities.Consulta;

public class ConsultaDTO {

    private Long id;
    private Long clienteId;
    private Long nutricionistaId;
    private LocalDate dataConsulta;
    private String observacoes;
    
    public ConsultaDTO() {
    }


    public ConsultaDTO(Long id, Long clienteId, Long nutricionistaId, LocalDate dataConsulta, String observacoes) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.nutricionistaId = nutricionistaId;
		this.dataConsulta = dataConsulta;
		this.observacoes = observacoes;
	}

	public ConsultaDTO(Consulta consulta){
        id = consulta.getId();
        clienteId = consulta.getCliente().getId();
        nutricionistaId = consulta.getNutricionista().getId();
        dataConsulta = consulta.getDataConsulta();
        observacoes = consulta.getObservacoes();
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getClienteId() {
		return clienteId;
	}


	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}


	public Long getNutricionistaId() {
		return nutricionistaId;
	}


	public void setNutricionistaId(Long nutricionistaId) {
		this.nutricionistaId = nutricionistaId;
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
