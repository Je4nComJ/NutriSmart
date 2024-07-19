package com.gomesdevelopers.NutriSmart.dto;

import com.gomesdevelopers.NutriSmart.entities.Nutricionista;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NutricionistaDTO {

    private Long id;
    private String nome;
    private String crn;
    private String telefone;
    private String email;
    private String especialidade;
    private LocalDate dataContratacao;

    public NutricionistaDTO(Nutricionista nutricionista){
        id = nutricionista.getId();
        nome = nutricionista.getNome();
        crn = nutricionista.getCrn();
        telefone = nutricionista.getTelefone();
        email = nutricionista.getEmail();
        especialidade = nutricionista.getEspecialidade();
        dataContratacao = nutricionista.getDataContratacao();
    }


}
