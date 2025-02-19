package com.biblioteca.progetto.biblioteca.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.progetto.biblioteca.db.entity.Libro;
import com.biblioteca.progetto.biblioteca.db.entity.Prestito;

@Repository
public interface PrestitoRepo extends JpaRepository<Prestito, Long> {
    
    List<Libro> findByRestituito(boolean restituito);

}
