package com.gomesdevelopers.NutriSmart.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_nutricionista")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

    @ManyToMany(mappedBy = "nutricionistas")
    private Set<Cliente> clientes = new HashSet<>();

    @OneToMany(mappedBy = "nutricionista")
    private Set<Consulta> consultas = new HashSet<>();
    

}
