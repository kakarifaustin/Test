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

import com.example.test.Dto.IndividuDto;
import com.example.test.Helpers.Messages;
import com.example.test.Response.ResponseBody;
import com.example.test.Services.IndividuService;

@RestController
@RequestMapping("/etudiant")
public class IndividuController {
    
    @Autowired
    private IndividuService etudiantService;
    

    @PostMapping("/ajouter")
    public ResponseEntity<?> saveEtudiant(@RequestBody IndividuDto etudiantDto){
            IndividuDto etudiantDto2 = etudiantService.saveEtudiant(etudiantDto);  
            return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), etudiantDto2), HttpStatus.OK);
    }
    
    @GetMapping("/afficher")
    public ResponseEntity<?> getListEtudiant(){
        List<IndividuDto> etudiantDtos = etudiantService.getListEtudiant();
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), etudiantDtos), HttpStatus.OK);

    }

    @GetMapping("/afficher/{id}")
    public ResponseEntity<?> getEtudiantById(@PathVariable("id")  Long etudiantId){
        
        IndividuDto eDto=etudiantService.getEtudiantById(etudiantId);
     return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(), eDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") Long idEtudiant){
        etudiantService.deleteEtudiantById(idEtudiant);
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success()), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEtudiant(@RequestBody IndividuDto  etudiantDto, @PathVariable("id") Long id){
        return new ResponseEntity<>(new ResponseBody<>(true, Messages.success(),etudiantService.updateEtudiant(etudiantDto,id)), HttpStatus.OK);

    }

}
