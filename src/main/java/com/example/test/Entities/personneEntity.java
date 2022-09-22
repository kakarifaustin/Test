package com.example.test.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_personne")
public class PersonneEntity {
    
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
    

    public PersonneEntity(long id, String nom, String prenom, LocalDate dateNaissance, String numeroDocument,
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

    public PersonneEntity() {
    }

    @OneToMany(mappedBy = "personneEntity")
    private List<ChambreClient>listChambreClient;

    
    
}
