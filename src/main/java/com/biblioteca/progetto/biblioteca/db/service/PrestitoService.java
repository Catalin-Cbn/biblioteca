package com.biblioteca.progetto.biblioteca.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.progetto.biblioteca.db.entity.Prestito;
import com.biblioteca.progetto.biblioteca.db.repo.PrestitoRepo;

@Service
public class PrestitoService {

    @Autowired
    PrestitoRepo prestitoRepo;

    public List<Prestito> findAll() {
        return prestitoRepo.findAll();
    }

    public Optional<Prestito> findById(Long id) {
        return prestitoRepo.findById(id);
    }

    
}
