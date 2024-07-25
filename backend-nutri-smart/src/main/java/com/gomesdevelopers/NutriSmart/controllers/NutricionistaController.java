package com.gomesdevelopers.NutriSmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
