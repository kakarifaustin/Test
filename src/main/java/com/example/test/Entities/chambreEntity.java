package com.example.test.Entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_chambre")
public class ChambreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     @Column(nullable = false)
    private Date debut;
     @Column(nullable = false,length = 45)
    private String libelle;
     @Column(nullable = false,length = 10)
    private Long hotel_id; 

    private Date fin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "hotel_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Hotel hotelEntity;


    @OneToMany(mappedBy = "chambreEntity")
    private List<ChambreClient>listeChambreClients= new ArrayList<>();

    @OneToMany(mappedBy = "chambreEntity")
    private List<CategorieChambreEntity>listeCategorieChambres=new ArrayList<>();
}
