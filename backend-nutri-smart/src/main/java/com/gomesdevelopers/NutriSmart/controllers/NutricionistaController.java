package com.gomesdevelopers.NutriSmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomesdevelopers.NutriSmart.dto.ClienteDTO;
import com.gomesdevelopers.NutriSmart.dto.NutricionistaDTO;
import com.gomesdevelopers.NutriSmart.services.NutricionistaService;

@RestController
@RequestMapping("/nutricionista")
public class NutricionistaController {

    @Autowired
    private NutricionistaService service;

    @PostMapping
    public ResponseEntity<NutricionistaDTO> salvarNutricionista(@RequestBody NutricionistaDTO nutricionistaDTO){
        NutricionistaDTO novoNutricionista = service.salvarNutricionista(nutricionistaDTO);
        return ResponseEntity.ok(novoNutricionista);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<NutricionistaDTO>> listarNutricionistas(){
    	List<NutricionistaDTO> allNutris = service.listarNutricionista();
    	return ResponseEntity.ok(allNutris);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<NutricionistaDTO> buscarNutricionistaPorID(@PathVariable Long id){
        NutricionistaDTO nutricionista = service.buscarNutricionistaPorId(id);
        return ResponseEntity.ok(nutricionista);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<NutricionistaDTO> atualizarNutricionista(@PathVariable Long id, @RequestBody NutricionistaDTO nutricionistaDTO){
        NutricionistaDTO nutricionistaAtualizado = service.atualizarNutricionista(id, nutricionistaDTO);
        return ResponseEntity.ok(nutricionistaAtualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNutricionista(@PathVariable Long id){
    	service.deletarNutricionista(id);
    	return ResponseEntity.noContent().build();
    }
    
    
}
