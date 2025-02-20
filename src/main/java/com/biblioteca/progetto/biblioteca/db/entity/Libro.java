package com.biblioteca.progetto.biblioteca.db.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String autore;

    @Column(length = 64)
    private String titolo;

    private int nCopieTotali;
    private int nCopieDisponibili;

    @JsonBackReference
    @OneToMany(mappedBy = "libro")
    private List<Prestito> prestiti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getnCopieDisponibili() {
        return nCopieDisponibili;
    }

    public void setnCopieDisponibili(int nCopieDisponibili) {
        this.nCopieDisponibili = nCopieDisponibili;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

     public int getnCopieTotali() {
        return nCopieTotali;
    }

    public void setnCopieTotali(int nCopieTotali) {
        this.nCopieTotali = nCopieTotali;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", autore=" + autore + ", titolo=" + titolo + ", nCopieTotali=" + nCopieTotali
                + ", nCopieDisponibili=" + nCopieDisponibili + "]";
    }

    


    

   
    
    
}   

