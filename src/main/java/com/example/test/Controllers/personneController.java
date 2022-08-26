package com.example.test.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Dto.personneDto;
import com.example.test.Helpers.Messages;
import com.example.test.Response.ResponseBody;
import com.example.test.Services.personneService;

@RestController
@RequestMapping("/personne")
public class personneController {
  

    @Autowired
    private personneService personneService;
     
    @PostMapping("/add")
    public ResponseEntity<?>enregistrerPersonne(@RequestBody personneDto personneDto)
    {

        personneDto personneDto2=personneService.enregistrerPersonne(personneDto);
        
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(),personneDto2),HttpStatus.OK );
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<?>modifierPersonne(@PathVariable("id") Long id,@RequestBody personneDto personneDto){

        personneDto personneDto2=personneService.modifierPersonne(personneDto, id);
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), personneDto2), HttpStatus.OK);

    }
    @GetMapping("/afficher")
    public ResponseEntity<?>afficherPersonne(){

      List<personneDto>listPersonnes= personneService.affichePersonnes();

      return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), listPersonnes), HttpStatus.OK);
    }
    
}
