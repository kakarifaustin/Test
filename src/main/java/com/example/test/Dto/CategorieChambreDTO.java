package com.example.test.Dto;

import lombok.Data;

@Data
public class CategorieChambreDTO {
private String typeS;
private String prix;
private Integer chambre_id;
private String debutS;
private String finS;
private ChambreDTO chambreDTO;
    
}
