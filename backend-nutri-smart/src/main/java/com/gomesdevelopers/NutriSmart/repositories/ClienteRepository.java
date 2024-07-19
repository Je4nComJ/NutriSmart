package com.gomesdevelopers.NutriSmart.repositories;

import com.gomesdevelopers.NutriSmart.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
