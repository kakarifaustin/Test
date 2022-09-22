package com.example.test.Entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_hotel")
public class Hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 10)
    private String code;
    @Column(nullable = false,length = 100)
    private String designation;
    private String representant;
    private String email;
    @Column(nullable = false)
    private String tel;
    private String siteWeb;
    @Column(nullable = false)
    private Date debut;
    private Date fin;


    @OneToMany(mappedBy = "hotelEntity")
    private List<ChambreEntity>listChambres=new ArrayList<>();
}
