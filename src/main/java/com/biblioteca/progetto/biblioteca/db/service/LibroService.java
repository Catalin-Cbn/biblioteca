package com.biblioteca.progetto.biblioteca.db.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.progetto.biblioteca.db.entity.Libro;
import com.biblioteca.progetto.biblioteca.db.entity.Prestito;
import com.biblioteca.progetto.biblioteca.db.repo.LibroRepo;
import com.biblioteca.progetto.biblioteca.db.repo.PrestitoRepo;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotDeletableException;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotEditableException;
import com.biblioteca.progetto.biblioteca.web.exception.BookNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class LibroService {

    @Autowired
    private LibroRepo libroRepo;

    @Autowired
    private PrestitoRepo prestitoRepo;

    @Transactional
    public List<Libro> findAll() {
        List<Libro> listaLibri = libroRepo.findAll();
        for (Libro libro : listaLibri) {
            Hibernate.initialize(libro.getPrestiti());
        }
        
        
        return listaLibri;
    }

    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    public List<Libro> findByAutoreAndTitolo(String autore, String Libro) {
        return libroRepo.findByTitoloAndAutore(autore, Libro);
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
        List<Prestito> prestiti = prestitoRepo.findByLibroAndRestituito(libro, false);
        if (copie < prestiti.size()) {
            throw new BookNotEditableException("Ci sono " + prestiti.size()
                    + "copie in prestito, quindi non puoi aggiornare con " + copie + " copie");
        }
        libro.setnCopieTotali(copie);
        libroRepo.save(libro);

    }

    public List<Libro> findByAutore(String autore) {
        return libroRepo.findByAutore(autore);
    }

    public List<Libro> findByTitolo(String titolo) {
        return libroRepo.findByTitolo(titolo);
    }

    public void deleteById(Long id) {
        Libro libro = libroRepo.findById(id).orElse(null);
        if (libro == null) {
            throw new BookNotFoundException("Il libro con id " + id + " non è presente nel database.");
        }
        List<Prestito> prestiti = prestitoRepo.findByLibroAndRestituito(libro, false);
        if(prestiti == null || prestiti.size() == 0) {       //se la lista dei prestiti è vuota, possiamo eliminare il libro dal database, altrimenti passiamo l'exception
            libroRepo.deleteById(id);
        } else {
            throw new BookNotDeletableException("Ci sono " + prestiti.size() + " copie del libro in prestito");
        }
        
    }

    
}
