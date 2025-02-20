package com.biblioteca.progetto.biblioteca.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.progetto.biblioteca.db.entity.Utente;
import com.biblioteca.progetto.biblioteca.db.service.UtenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping("/elencoUtenti")
    public List<Utente> elencoUtenti() {
        return utenteService.findAll() ;
    }

    @PostMapping("aggiungiUtente")
    public void aggiungiUtente(@RequestBody Utente utente) {
        
        utenteService.save(utente);
        
    }
    
    
}
