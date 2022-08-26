package com.example.test.Entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_personne")
public class personneEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String numeroDocument;
    private String nationalite;
    private Integer typeDocument;
    private Integer typePersonne;
    private String fone;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getNumeroDocument() {
        return numeroDocument;
    }
    public void setNumeroDocument(String numeroDocument) {
        this.numeroDocument = numeroDocument;
    }
    public String getNationalite() {
        return nationalite;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    public Integer getTypeDocument() {
        return typeDocument;
    }
    public void setTypeDocument(Integer typeDocument) {
        this.typeDocument = typeDocument;
    }
    public Integer getTypePersonne() {
        return typePersonne;
    }
    public void setTypePersonne(Integer typePersonne) {
        this.typePersonne = typePersonne;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public personneEntity() {
    }
    
    public personneEntity(long id, String nom, String prenom, LocalDate dateNaissance, String numeroDocument,
            String nationalite, Integer typeDocument, Integer typePersonne, String fone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroDocument = numeroDocument;
        this.nationalite = nationalite;
        this.typeDocument = typeDocument;
        this.typePersonne = typePersonne;
        this.fone = fone;
    }

    
}
