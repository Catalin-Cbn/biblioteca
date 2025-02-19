package com.biblioteca.progetto.biblioteca.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.progetto.biblioteca.db.entity.Libro;
import com.biblioteca.progetto.biblioteca.db.service.LibroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping("/elencoLibri")
    public List<Libro> getElencoLibri(@RequestParam(required = false) String autore, @RequestParam(required = false) String titolo ) {
        if(autore != null) {
            
            return libroService.findByAutore(autore);            
        }
        if(titolo != null) {

            return libroService.findByTitolo(titolo);
        }

        return libroService.findAll();
    }

    @PostMapping("/aggiungiLibro")
    public void aggiungiLibro(@RequestBody Libro libro) {
        
        libroService.save(libro);        
    }
    
    @PutMapping("aggiornaCopie/{id}")
    public void aggiornaCopie(@PathVariable Long id, @RequestParam int copie) {
        libroService.aggiornaCopie(id, copie);
        
    }

    @DeleteMapping("/eliminaLibro/{id}")
    public void eliminaLibro(@PathVariable Long id) {
        libroService.deleteById(id);
    }
}
