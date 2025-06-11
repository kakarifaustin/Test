package com.example.test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.ConvertDTO.ChambreConvertDTO;
import com.example.test.Dto.ChambreDTO;
import com.example.test.Entities.ChambreEntity;
import com.example.test.Helpers.helper;
import com.example.test.repositories.ChambreRepository;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;
 
    public void enregistrerChambre(ChambreDTO chambreDTO){

        chambreRepository.save(ChambreConvertDTO.getInstance().convertDtoToEntity(chambreDTO));
    }


    public void modifierChambre(Long id,ChambreDTO chambreDTO){
        ChambreEntity chambreModif=chambreRepository.findById(id).get();
        if(chambreModif!=null){
            chambreModif.setLibelle(chambreDTO.getLibelle());
            chambreModif.setDebut(helper.convertStringToDate(chambreDTO.getDebutS()));
            chambreModif.setFin(helper.convertStringToDate(chambreDTO.getFinS()));
            chambreModif.setHotel_id(chambreDTO.getHotel_id());

            chambreRepository.save(chambreModif);
        }
    }

    public List<ChambreDTO>afficherChambres(){
        List<ChambreEntity>listeChambres=chambreRepository.findAll();
        List<ChambreDTO>listeChambreDtos=new ArrayList<>();

        for(ChambreEntity chambreEntity:listeChambres){
            listeChambreDtos.add(ChambreConvertDTO.getInstance().convertEntityToDto(chambreEntity));
        }
        return listeChambreDtos;
        

    }

    public void supprimerChambre(Long id){
        boolean exist=chambreRepository.existsById(id);
        if(!exist)
        throw new IllegalStateException("Le hotel avec id:"+id+" n'existe pas");
        else
        chambreRepository.deleteById(id);

    }
    
}
