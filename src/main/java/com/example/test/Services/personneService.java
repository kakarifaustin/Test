package com.example.test.Services;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.test.Dto.personneDto;
import com.example.test.Entities.personneEntity;
import com.example.test.repositories.personneRespository;

@Service
public class personneService {

    @Autowired
   private personneRespository personneRespository;

    private personneEntity convertDtoToEntity(personneDto personneDto){
        personneEntity personne=new personneEntity();
        personne.setNom(personneDto.getNom());
        personne.setPrenom(personneDto.getPrenom());
        personne.setDateNaissance(personneDto.getDateNaissance());
        personne.setNationalite(personneDto.getNationalite());
        personne.setNumeroDocument(personneDto.getNumeroDocument());
        personne.setTypeDocument(getTypeDocumentInt(personneDto.getTypeDocument()));
        personne.setFone(personneDto.getFone());
        personne.setTypePersonne(getTypePersonneInt(personneDto.getTypePersonne()));
       
        return personne;
    }

    private personneDto convertEntityToDto(personneEntity personneEntity){
        personneDto personneDto=new personneDto();
        personneDto.setNom(personneEntity.getNom());
        personneDto.setPrenom(personneEntity.getPrenom());
        personneDto.setDateNaissance(personneEntity.getDateNaissance());
        personneDto.setNationalite(personneEntity.getNationalite());
        personneDto.setNumeroDocument(personneEntity.getNumeroDocument());
        personneDto.setTypeDocument(getLibelleTypeDocument(personneEntity.getTypeDocument()));
        personneDto.setTypePersonne(getLibelleTypePersonne(personneEntity.getTypePersonne()));
        personneDto.setFone(personneEntity.getFone());

            if(personneEntity.getTypeDocument()!=null)
       personneDto.setTypeDocument(getLibelleTypeDocument(personneEntity.getTypeDocument()));
            if(personneEntity.getTypePersonne()!=null)
       personneDto.setTypePersonne(getLibelleTypePersonne(personneEntity.getTypePersonne()));
        
        return personneDto;
    }

    private String getLibelleTypeDocument(int type){
        String libelle="";
        if(type==1)
            libelle="CNI";
        else if(type==2)
            libelle="Passeport";
        else if(type==3)
            libelle="Permis de conduire";
        else if(type==4)
            libelle="Autres";
        
        return libelle;
    }

    private String getLibelleTypePersonne(int type){
        String libelle="";
        if(type==1)
            libelle="Client";
        else if(type==2)
            libelle="Réceptioniste";
        else if(type==3)
            libelle="Comptable";
        else if(type==4)
            libelle="Gérant";
        
        return libelle;
    }


    private int getTypeDocumentInt(String libelle){
        int type=0;
        if(libelle.equalsIgnoreCase(" 1 "))
           type=1;
        else if(libelle.equalsIgnoreCase("2"))
            type=2;
        else if(libelle.equalsIgnoreCase("3"))
            type=3;
        else if(libelle.equalsIgnoreCase("4"))
            type=4;
        
        return type;
    }

    private int getTypePersonneInt(String libelle){
        int type=0;
        if(libelle.equalsIgnoreCase("1"))
           type=1;
        else if(libelle.equalsIgnoreCase("2"))
            type=2;
        else if(libelle.equalsIgnoreCase("3"))
            type=3;
        else if(libelle.equalsIgnoreCase("4"))
            type=4;
        return type;
    }

    public personneDto enregistrerPersonne(personneDto personneDto){
       
        personneEntity personneEntity=convertDtoToEntity(personneDto);
        
        return convertEntityToDto(personneRespository.save(personneEntity));
    }

    public List<personneDto>affichePersonnes(){
        return personneRespository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    public personneDto modifierPersonne(personneDto personneDto,Long id){

        personneEntity per=personneRespository.findById(id).get();
        
        per.setNom(personneDto.getNom());
        per.setPrenom(personneDto.getPrenom());
        per.setFone(personneDto.getFone());
        per.setNationalite(personneDto.getNationalite());
        per.setDateNaissance(personneDto.getDateNaissance());
        per.setTypeDocument(getTypeDocumentInt(personneDto.getTypeDocument()));
        per.setNumeroDocument(personneDto.getNumeroDocument());
        per.setTypePersonne(getTypePersonneInt(personneDto.getTypePersonne()));
        
        return convertEntityToDto(personneRespository.save(per));

    }
}
