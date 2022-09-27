package com.example.test.ConvertDTO;

import com.example.test.Dto.hotelDto;
import com.example.test.Entities.Hotel;
import com.example.test.Helpers.helper;

public class HotelConvertDTO {


public static HotelConvertDTO getInstance(){
    return new HotelConvertDTO();
}


    public hotelDto convertEntityTHotelToDto(Hotel hotel){

        hotelDto hotelDto=new hotelDto();
        hotelDto.setCode(hotel.getCode());
        hotelDto.setDesignation(hotel.getDesignation());
        hotelDto.setEmail(hotel.getEmail());
        hotelDto.setRepresentant(hotel.getRepresentant());
        hotelDto.setSiteWeb(hotel.getSiteWeb());
        hotelDto.setTel(hotel.getTel());
        if(hotel.getDebut()!=null)
        hotelDto.setDebutS(helper.convertDateToString(hotel.getDebut()));
        if(hotel.getFin()!=null)
        hotelDto.setFinS(helper.convertDateToString(hotel.getFin()));
        return hotelDto;

    }


    public Hotel convertDtoToEntity(hotelDto hotelDto){

        Hotel hotel=new Hotel();
        hotel.setCode(hotelDto.getCode());
        hotel.setDesignation(hotelDto.getDesignation());
        hotel.setEmail(hotelDto.getEmail());
        hotel.setRepresentant(hotelDto.getRepresentant());
        hotel.setSiteWeb(hotelDto.getSiteWeb());
        hotel.setTel(hotelDto.getTel());
            if(hotelDto.getDebutS()!=null&&!hotelDto.getDebutS().trim().equals(""))
        hotel.setDebut(helper.convertStringToDate(hotelDto.getDebutS()));
             if(hotelDto.getFinS()!=null&&!hotelDto.getFinS().trim().equals(""))
        hotel.setFin(helper.convertStringToDate(hotelDto.getFinS()));
        return hotel;

    }

    
}
