package com.example.test.Entities;

import java.util.Date;

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
@Table(name="tbl_categorie_chambre")
public class CategorieChambreEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @Column(nullable = false,length = 45)
    private Integer type;
        @Column(nullable = false,length = 45)
    private float prix;
        @Column(nullable = false,length = 10)
    private Integer chambre_id;
        @Column(nullable = false)
    private Date debut;
    private Date fin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="chambre_id",referencedColumnName="id",insertable=false,updatable=false)
    private ChambreEntity chambreEntity;


    
}
