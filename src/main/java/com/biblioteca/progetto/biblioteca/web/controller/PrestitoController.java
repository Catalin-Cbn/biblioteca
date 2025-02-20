package com.biblioteca.progetto.biblioteca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.progetto.biblioteca.db.service.PrestitoService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/prestito")
public class PrestitoController {

    @Autowired
    PrestitoService prestitoService;

    @PostMapping("aggiungiPrestito")
    public void aggiungiPrestito(@RequestParam Long libroId) {
        
        prestitoService.creaPrestito(libroId);
    }
    
}
