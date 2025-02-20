package com.biblioteca.progetto.biblioteca.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.progetto.biblioteca.db.entity.Utente;
import com.biblioteca.progetto.biblioteca.db.repo.UtenteRepo;

@Service
public class UtenteService {

    @Autowired
    UtenteRepo utenteRepo;

    public List<Utente> findAll() {
        return utenteRepo.findAll();
    }

    public Optional<Utente> findById(Long id) {
        return utenteRepo.findById(id);
    }

    public void save(Utente utente) {

        utenteRepo.save(utente);
    }
    
}
