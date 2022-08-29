package com.example.test.Entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        @NotNull(message = "Le code est obligatoire")
    private String code;
        @NotNull(message = "La désignation est obligatoire")
    private String designation;
    private String representant;
        @Email(message = "Le format d'email n'est pas respecté")
    private String email;
    private String tel;
    private String siteWeb;
        @NotNull(message = "La date début est obligatoire")
    private Date debut;
    private Date fin;
}
