package com.gomesdevelopers.NutriSmart.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_nutricionista")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "crn", nullable = false)
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

}
