package com.example.test.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Dto.hotelDto;
import com.example.test.Helpers.Messages;
import com.example.test.Response.ResponseBody;
import com.example.test.Services.hotelService;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class hotelController {
    
    @Autowired
    private hotelService hotelService;

@PostMapping("/ajouter")
public ResponseEntity<?> saveHotel(@RequestBody hotelDto hotelDto){
    if(hotelDto.getCode()==null||hotelDto.getCode().trim().equals(""))
        return new ResponseEntity<>(new ResponseBody<>(false,"Le code est obligatoire"), HttpStatus.NOT_FOUND);
    else if(hotelDto.getDesignation()==null || hotelDto.getDesignation().trim().equals(""))
        return new ResponseEntity<>(new ResponseBody<>(false,"La désignation est obligatoire"), HttpStatus.NOT_FOUND);
    else if(hotelDto.getRepresentant()==null || hotelDto.getRepresentant().trim().equals(""))
        return new ResponseEntity<>(new ResponseBody<>(false,"Le représentant est obligatoire"), HttpStatus.NOT_FOUND);
    else if(hotelDto.getTel()==null || hotelDto.getTel().trim().equals(""))
        return new ResponseEntity<>(new ResponseBody<>(false,"Le téléphone est obligatoire"), HttpStatus.NOT_FOUND);
    else if(hotelDto.getDebutS()==null || hotelDto.getDebutS().trim().equals(""))
        return new ResponseEntity<>(new ResponseBody<>(false,"La date début est obligatoire"), HttpStatus.NOT_FOUND);
    else{
        try {
            hotelDto hotelDto2=hotelService.enregistrerHotel(hotelDto);
            return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), hotelDto2), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody<>(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
       
    }
 
}

@PutMapping("/modifier/{id}")
public ResponseEntity<?> updateHotel(@PathVariable("id") Long id,@RequestBody hotelDto hotelDto){

    hotelDto hotelDto2=hotelService.updateHotel(hotelDto,id);
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), hotelDto2), HttpStatus.OK);
    
    }   


    @GetMapping("/afficher")
    public ResponseEntity<?>afficherHotel(){
        List<hotelDto>listHotels= hotelService.afficherHotel();

        System.out.println("Liste hotel:");

        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), listHotels), HttpStatus.OK);        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>supprimerHotel(@PathVariable("id") Long idHoteL){

        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success()), HttpStatus.OK);
    }
}
