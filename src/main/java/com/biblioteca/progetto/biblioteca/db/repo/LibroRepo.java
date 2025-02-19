package com.biblioteca.progetto.biblioteca.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.progetto.biblioteca.db.entity.Libro;
import java.util.List;


@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {

    List<Libro> findByAutore(String autore);
    List<Libro> findByTitolo(String titolo);
    List<Libro> findByTitoloAndAutore(String autore, String titolo);
}
