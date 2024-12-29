package com.gomesdevelopers.NutriSmart.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_cliente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @ManyToMany
    @JoinTable(
    		name = "tb_cliente_nutricionista",
    		joinColumns = @JoinColumn(name = "cliente_id"),
    		inverseJoinColumns = @JoinColumn(name = "nutricionista_id")
    		)
    private Set<Nutricionista> nutricionistas = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<Consulta> consultas = new HashSet<>();

}
