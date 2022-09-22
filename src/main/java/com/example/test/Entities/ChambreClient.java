package com.example.test.Entities;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="tbl_chambre_client")
public class ChambreClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @Column(name = "chambre_id",nullable = false,length = 10)
    private Integer chambreId;
        @Column(name = "personne_id",nullable = false,length = 10)
    private Integer personneId;
        @Column(name = "receptioniste_id",nullable = false,length = 10)
    private Integer receptionisteId;
       @Column(nullable = false,length = 50)
    private float montant;
        @Column(nullable = false)
    private Timestamp debut;
    private Timestamp fin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personne_id",referencedColumnName = "id",insertable = false,  updatable = false)
    private PersonneEntity personneEntity;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chambre_id",referencedColumnName = "id",insertable = false,  updatable = false)
    private ChambreEntity chambreEntity;

    

    
}
