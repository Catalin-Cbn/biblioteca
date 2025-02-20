package com.biblioteca.progetto.biblioteca.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.progetto.biblioteca.db.entity.Prestito;
import com.biblioteca.progetto.biblioteca.db.service.PrestitoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/prestito")
public class PrestitoController {

    @Autowired
    PrestitoService prestitoService;

    @PostMapping("/aggiungiPrestito")
    public void aggiungiPrestito(@RequestParam Long libroId, @RequestParam Long utenteId) {
        
        prestitoService.creaPrestito(libroId, utenteId);
    }
    
    @GetMapping("/elencoPrestiti")
    public List<Prestito> elencoPrestiti() {
        return prestitoService.findAll();
    }

    @PostMapping("/restituisciPrestito")
    public void restituisciPrestito(@RequestParam Long prestitoId) {
    
        prestitoService.restituisciPrestito(prestitoId);
    }
    
    
}
