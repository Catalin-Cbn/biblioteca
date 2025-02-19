package com.biblioteca.progetto.biblioteca.db.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.progetto.biblioteca.db.entity.Libro;
import com.biblioteca.progetto.biblioteca.db.repo.LibroRepo;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotEditableException;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class LibroService {

    @Autowired
    LibroRepo libroRepo;

    public List<Libro> findAll() {
        return libroRepo.findAll();
    }

    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    public void save(Libro libro) {
        libroRepo.save(libro);
    }

    @Transactional
    public void aggiornaCopie(Long id, int copie) {
        Libro libro = libroRepo.findById(id).orElse(null);

        if (libro == null) {
            throw new BookNotFoundException("Il libro con id " + id + " non è presente nel database.");
        }

        Hibernate.initialize(libro.getPrestiti());
        if (copie < libro.getPrestiti().size()) {
            throw new BookNotEditableException("Ci sono " + libro.getPrestiti().size()
                    + "copie in prestito, quindi non puoi aggiornare con " + copie + " copie");
        }
        libro.setnCopieDisponibili(copie);
        libroRepo.save(libro);

    }

    public List<Libro> findByAutore(String autore) {
        return libroRepo.findByAutore(autore);
    }

    public List<Libro> findByTitolo(String titolo) {
        return libroRepo.findByTitolo(titolo);
    }

    public void deleteById(Long id) {
        libroRepo.deleteById(id);
    }

    
    
}
