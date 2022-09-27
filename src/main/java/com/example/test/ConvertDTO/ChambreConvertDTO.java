package com.example.test.ConvertDTO;

import com.example.test.Dto.ChambreDTO;
import com.example.test.Entities.ChambreEntity;
import com.example.test.Helpers.helper;

public class ChambreConvertDTO {

    public static ChambreConvertDTO getInstance(){
        return new ChambreConvertDTO();
    }

    public ChambreDTO convertEntityToDto(ChambreEntity chambreEntity){

        ChambreDTO chambreDTO=new ChambreDTO();
        chambreDTO.setLibelle(chambreEntity.getLibelle());
        chambreDTO.setDebutS(helper.convertDateToString(chambreEntity.getDebut()));
        chambreDTO.setFinS(helper.convertDateToString(chambreEntity.getFin()));
        chambreDTO.setHotel_id(chambreEntity.getHotel_id());
        chambreDTO.setHotelDto(HotelConvertDTO.getInstance().convertEntityTHotelToDto(chambreEntity.getHotelEntity()));

        return chambreDTO;
    }

    public ChambreEntity convertDtoToEntity(ChambreDTO chambreDTO){

        ChambreEntity chambreEntity=new ChambreEntity();
        chambreEntity.setLibelle(chambreDTO.getLibelle());
        chambreEntity.setDebut(helper.convertStringToDate(chambreDTO.getDebutS()));
        if(chambreDTO.getFinS()!=null && !chambreDTO.getFinS().trim().equals(""))
        chambreEntity.setFin(helper.convertStringToDate(chambreDTO.getFinS()));
        chambreEntity.setHotel_id(chambreDTO.getHotel_id());

        return chambreEntity;
    }

    
}
