package com.biblioteca.progetto.biblioteca.db.entity;

import java.util.List;

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

    private int nCopieDisponibili;
    private boolean restituito;

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

    public boolean isRestituito() {
        return restituito;
    }

    public void setRestituito(boolean restituito) {
        this.restituito = restituito;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", autore=" + autore + ", titolo=" + titolo + ", nCopieDisponibili="
                + nCopieDisponibili + ", restituito=" + restituito + "]";
    }

}
