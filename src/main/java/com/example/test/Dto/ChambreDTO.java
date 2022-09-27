package com.example.test.Dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@JsonInclude(value = Include.NON_NULL)
public class ChambreDTO {
    private String debutS;
    private String libelle;
    private Long hotel_id; 
    private String finS;
    private hotelDto hotelDto;



    
}
