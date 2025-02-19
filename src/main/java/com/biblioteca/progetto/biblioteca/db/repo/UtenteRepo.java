package com.biblioteca.progetto.biblioteca.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.progetto.biblioteca.db.entity.Utente;

public interface UtenteRepo extends JpaRepository<Utente, Long> {

}
