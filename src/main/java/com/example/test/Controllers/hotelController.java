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
       
  hotelDto hotelDto2=hotelService.enregistrerHotel(hotelDto);
  if(hotelDto2==null) throw new ImpossibleAjouterException("Echec de l'opération");
    return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), hotelDto2), HttpStatus.OK);
   
}

@PutMapping("/modifier/{id}")
public ResponseEntity<?> updateHotel(@PathVariable("id") Long id,@RequestBody hotelDto hotelDto){

    hotelDto hotelDto2=hotelService.updateHotel(hotelDto,id);

    if(hotelDto2==null) throw new ElementNotFoundException("pbm")

        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), hotelDto2), HttpStatus.OK);
    
    }   

@GetMapping("/afficher")
    public ResponseEntity<?>afficherHotel(){
        List<hotelDto>listHotels= hotelService.afficherHotel();

        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), listHotels), HttpStatus.OK);        
    }

@DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?>supprimerHotel(@PathVariable("id") Long idHoteL){
        try {
            hotelService.supprimerHotel(idHoteL);
            return new ResponseEntity<>(new ResponseBody<>(true, Messages.success()), HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody<>(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        
    }
}
