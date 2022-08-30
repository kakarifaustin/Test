package com.example.test.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.Dto.hotelDto;
import com.example.test.Entities.hotel;
import com.example.test.Helpers.helper;
import com.example.test.repositories.hotelRepository;

@Service
public class hotelService {

    @Autowired
    private hotelRepository hotelRepository;



    private hotelDto convertEntityTHotelToDto(hotel hotel){

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


    private hotel convertDtoToEntity(hotelDto hotelDto){

        hotel hotel=new hotel();
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

    public hotelDto updateHotel(hotelDto hotelDto,Long id){
        hotel hotelModif=hotelRepository.findById(id).get();
        hotelModif.setCode(hotelDto.getCode());
        hotelModif.setDesignation(hotelDto.getDesignation());
        hotelModif.setEmail(hotelDto.getEmail());
        hotelModif.setSiteWeb(hotelDto.getSiteWeb());
        hotelModif.setRepresentant(hotelModif.getRepresentant());
            if(hotelDto.getDebutS()!="" && hotelDto.getDebutS()!=null)
        hotelModif.setDebut(helper.convertStringToDate(hotelDto.getDebutS()));
            if(hotelDto.getFinS()!="" && hotelDto.getFinS()!=null)
        hotelModif.setFin(helper.convertStringToDate(hotelDto.getFinS()));

        return convertEntityTHotelToDto(hotelRepository.save(hotelModif));
            }

            
    public hotelDto enregistrerHotel(hotelDto hotelDto){
        hotel hotel=convertDtoToEntity(hotelDto);
         
    return convertEntityTHotelToDto(hotelRepository.save(hotel));
      }


      public List<hotelDto>afficherHoptel(){
        return hotelRepository.findAll().stream().map(this::convertEntityTHotelToDto).collect(Collectors.toList());
       }

    public void supprimerHotel(Long idHotel){
      boolean trouve=hotelRepository.existsById(idHotel);

      if(!trouve)
       throw new IllegalStateException("Le hotel avec id:"+idHotel+" n'existe pas");
       else
       hotelRepository.deleteById(idHotel);
    }
    
}
