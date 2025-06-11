package com.example.test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.ConvertDTO.HotelConvertDTO;
import com.example.test.Dto.hotelDto;
import com.example.test.Entities.Hotel;
import com.example.test.Helpers.helper;
import com.example.test.repositories.hotelRepository;

@Service
public class hotelService {

    @Autowired
    private hotelRepository hotelRepository;

   
            
    public hotelDto enregistrerHotel(hotelDto hotelDto){
        Hotel hotel=HotelConvertDTO.getInstance().convertDtoToEntity(hotelDto);
         
    return HotelConvertDTO.getInstance().convertEntityTHotelToDto(hotelRepository.save(hotel));
      }

    public hotelDto updateHotel(hotelDto hotelDto,Long id){
        Hotel hotelModif=hotelRepository.findById(id).get();
        hotelModif.setCode(hotelDto.getCode());
        hotelModif.setDesignation(hotelDto.getDesignation());
        hotelModif.setEmail(hotelDto.getEmail());
        hotelModif.setSiteWeb(hotelDto.getSiteWeb());
        hotelModif.setRepresentant(hotelDto.getRepresentant());
        hotelModif.setTel(hotelDto.getTel());
            if(hotelDto.getDebutS()!="" && hotelDto.getDebutS()!=null)
        hotelModif.setDebut(helper.convertStringToDate(hotelDto.getDebutS()));
            if(hotelDto.getFinS()!="" && hotelDto.getFinS()!=null)
        hotelModif.setFin(helper.convertStringToDate(hotelDto.getFinS()));

        return HotelConvertDTO.getInstance().convertEntityTHotelToDto(hotelRepository.save(hotelModif));
            }

    public List<hotelDto>afficherHotel(){
        List<Hotel>listHotels=hotelRepository.findAll();
        List<hotelDto>listHotelDtos=new ArrayList<>();

        for(Hotel hotel:listHotels){
            listHotelDtos.add(HotelConvertDTO.getInstance().convertEntityTHotelToDto(hotel));
        } 

        return listHotelDtos;
       }

    public void supprimerHotel(Long idHotel){
      boolean trouve=hotelRepository.existsById(idHotel);

      if(trouve)
        hotelRepository.deleteById(idHotel);
      else
       throw new IllegalStateException("Le hotel avec id:"+idHotel+" n'existe pas");
             
    }
    
}
