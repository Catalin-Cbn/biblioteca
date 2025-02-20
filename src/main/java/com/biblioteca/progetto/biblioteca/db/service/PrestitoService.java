package com.biblioteca.progetto.biblioteca.db.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.progetto.biblioteca.db.entity.Libro;
import com.biblioteca.progetto.biblioteca.db.entity.Prestito;
import com.biblioteca.progetto.biblioteca.db.entity.Utente;
import com.biblioteca.progetto.biblioteca.db.repo.LibroRepo;
import com.biblioteca.progetto.biblioteca.db.repo.PrestitoRepo;
import com.biblioteca.progetto.biblioteca.db.repo.UtenteRepo;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotFoundException;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotLendableException;

@Service
public class PrestitoService {

    @Autowired
    PrestitoRepo prestitoRepo;

    @Autowired
    LibroRepo libroRepo;

    @Autowired
    UtenteRepo utenteRepo;

    public List<Prestito> findAll() {
        return prestitoRepo.findAll();
    }

    public Prestito findById(Long id) {
        return prestitoRepo.findById(id).orElse(null);
    }

    public void save(Prestito prestito) {
        prestitoRepo.save(prestito);
    }

    public void creaPrestito(Long libroId, Long utenteId) {
        Prestito prestito = new Prestito();
        Libro libro = libroRepo.findById(libroId).orElse(null);
        Utente utente = utenteRepo.findById(utenteId).orElse(null);
        if (libro == null) {
            throw new BookNotFoundException("Il libro con id " + libroId + " non è stato trovato.");
        }
        int copieDisponibili = libro.getnCopieDisponibili();
        if (copieDisponibili > 0) {

            libro.setnCopieDisponibili(copieDisponibili - 1);
        } else {
            throw new BookNotLendableException("Il libro non è disponibile per il prestito");
        }

        prestito.setDataInizio(LocalDate.now());
        prestito.setLibro(libro);
        prestito.setUtente(utente);
        save(prestito);
    }

}
