package com.example.test.ConvertDTO;

import com.example.test.Dto.CategorieChambreDTO;
import com.example.test.Entities.CategorieChambreEntity;
import com.example.test.Helpers.helper;

public class CategorieChambreConvertDTO {

    public static CategorieChambreConvertDTO getInstance(){
        return new CategorieChambreConvertDTO();
    }

    public CategorieChambreDTO convertEntityToDto(CategorieChambreEntity categorieChambreEntity){
        CategorieChambreDTO catDTO=new CategorieChambreDTO();
        catDTO.setChambreDTO(ChambreConvertDTO.getInstance().convertEntityToDto(categorieChambreEntity.getChambreEntity()));
        catDTO.setChambre_id(categorieChambreEntity.getChambre_id());
        if(categorieChambreEntity.getDebut()!=null)
        catDTO.setDebutS(helper.convertDateTimeToString(categorieChambreEntity.getDebut()));
        catDTO.setFinS(helper.convertDateTimeToString(categorieChambreEntity.getFin()));
        catDTO.setTypeS(helper.getTypeS(categorieChambreEntity.getType()));
        catDTO.setPrix(categorieChambreEntity.getPrix()+"");
        
        return catDTO;
    }

        public CategorieChambreEntity convertDtoToEntity(CategorieChambreDTO categorieChambreDTO){
            CategorieChambreEntity cat=new CategorieChambreEntity();
            cat.setChambre_id(categorieChambreDTO.getChambre_id());
            if(categorieChambreDTO.getDebutS()!=null)
            // cat.setDebut(helper.convertStringToDateTime(categorieChambreDTO.getDebutS()));
            // cat.setFin(helper.convertStringToDateTime(categorieChambreDTO.getFinS()));
            cat.setType(helper.getTypeInt(categorieChambreDTO.getTypeS()));
            // cat.setPrix(categorieChambreDTO.getPrix());
            
            return cat;
         }
    
}
