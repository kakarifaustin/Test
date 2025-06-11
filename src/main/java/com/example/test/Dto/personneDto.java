package com.example.test.Dto;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(value = Include.NON_NULL)
public class personneDto {

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String numeroDocument;
    private String nationalite;
    private String typeDocument;
    private String typePersonne;
    private String fone;
    
    
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
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public String getTypeDocument() {
        return typeDocument;
    }
    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }
    public String getTypePersonne() {
        return typePersonne;
    }
    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }
    public personneDto(String nom, String prenom, LocalDate dateNaissance, String numeroDocument,
            String nationalite, String typeDocument, String typePersonne, String fone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroDocument = numeroDocument;
        this.nationalite = nationalite;
        this.typeDocument = typeDocument;
        this.typePersonne = typePersonne;
        this.fone = fone;
    }

    public personneDto() {
    }

    
    
}
