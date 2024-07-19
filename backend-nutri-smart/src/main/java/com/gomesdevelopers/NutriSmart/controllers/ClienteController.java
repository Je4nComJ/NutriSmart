package com.gomesdevelopers.NutriSmart.controllers;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO novoCliente = service.salvarCliente(clienteDTO);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorID(@PathVariable Long id){
        ClienteDTO cliente = service.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<ClienteDTO> clientes = service.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        ClienteDTO clienteAtualizado = service.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();

    }

}
