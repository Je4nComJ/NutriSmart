package com.gomesdevelopers.NutriSmart.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.entities.Cliente;
import com.gomesdevelopers.NutriSmart.entities.Nutricionista;
import com.gomesdevelopers.NutriSmart.repositories.ClienteRepository;
import com.gomesdevelopers.NutriSmart.repositories.NutricionistaRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    private Cliente convertToEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setNome(clienteDTO.getNome());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setDataRegistro(clienteDTO.getDataRegistro());
        if (clienteDTO.getNutricionistaId() != null) {
            Nutricionista nutricionista = nutricionistaRepository.findById(clienteDTO.getNutricionistaId())
                    .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
            cliente.setNutricionista(nutricionista);
        }
        return cliente;
    }

    private ClienteDTO convertToDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEndereco(cliente.getEndereco());
        clienteDTO.setDataNascimento(cliente.getDataNascimento());
        clienteDTO.setDataRegistro(cliente.getDataRegistro());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setSexo(cliente.getSexo());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setNutricionistaId(cliente.getNutricionista() != null ? cliente.getNutricionista().getId() : null);

        return clienteDTO;
    }

    public ClienteDTO salvarCliente(ClienteDTO clienteDTO){
        Cliente cliente = convertToEntity(clienteDTO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return new ClienteDTO(savedCliente);
    }

    public List<ClienteDTO> listarClientes(){
        return clienteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ClienteDTO buscarClientePorId(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        return convertToDTO(cliente);
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setCpf(clienteDTO.getCpf());
        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setDataNascimento(clienteDTO.getDataNascimento());
        clienteExistente.setSexo(clienteDTO.getSexo());
        clienteExistente.setTelefone(clienteDTO.getTelefone());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setEndereco(clienteDTO.getEndereco());
        clienteExistente.setDataRegistro(clienteDTO.getDataRegistro());

        if (clienteDTO.getNutricionistaId() != null) {
            Nutricionista nutricionista = nutricionistaRepository.findById(clienteDTO.getNutricionistaId())
                    .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
            clienteExistente.setNutricionista(nutricionista);
        }

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
        return new ClienteDTO(clienteAtualizado);
    }


    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

}



