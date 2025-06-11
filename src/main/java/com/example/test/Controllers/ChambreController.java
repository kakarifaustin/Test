package com.example.test.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Dto.ChambreDTO;
import com.example.test.Helpers.Messages;
import com.example.test.Response.ResponseBody;
import com.example.test.Services.ChambreService;

@RestController
@RequestMapping("/chambre")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

@PostMapping("/ajouter")
public ResponseEntity<?> enregistrerChambre(@RequestBody ChambreDTO chambreDTO){
            chambreService.enregistrerChambre(chambreDTO);
    return new ResponseEntity<>(new ResponseBody<>(true, Messages.success()), HttpStatus.OK);
    }
@PutMapping("/modifier/{id}")
public ResponseEntity<?> updateChambre(@PathVariable("id") Long id,@RequestBody ChambreDTO chambreDTO){

    chambreService.modifierChambre(id,chambreDTO);
    return new ResponseEntity<>(new ResponseBody<>(true, Messages.success()), HttpStatus.OK);
    
    }   
@GetMapping("/afficher")
    public ResponseEntity<?>afficherChambres(){
        System.out.println("Yes I pass here");
        List<ChambreDTO>listChambres= chambreService.afficherChambres();
System.out.println("Liste:"+listChambres);
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), listChambres), HttpStatus.OK);        
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<?>supprimerChambre(@PathVariable("id") Long id){

        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success()), HttpStatus.OK);
    }
}
