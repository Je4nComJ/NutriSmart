package com.gomesdevelopers.NutriSmart.dto;

import com.gomesdevelopers.NutriSmart.entities.Cliente;
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


}
