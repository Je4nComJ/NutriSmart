package com.gomesdevelopers.NutriSmart.dto;

import com.gomesdevelopers.NutriSmart.entities.Consulta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultaDTO {

    private Long id;
    private Long clienteId;
    private Long nutricionistaId;
    private LocalDate dataConsulta;
    private String observacoes;

    public ConsultaDTO(Consulta consulta){
        id = consulta.getId();
        clienteId = consulta.getCliente().getId();
        nutricionistaId = consulta.getNutricionista().getId();
        dataConsulta = consulta.getDataConsulta();
        observacoes = consulta.getObservacoes();
    }
}
