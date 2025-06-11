package com.example.test.Services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.Dto.IndividuDto;
import com.example.test.Entities.IndividuEntity;
import com.example.test.repositories.IndividuRepository;

@Service
public class IndividuService {

    @Autowired
    private IndividuRepository etudiantRepository;
    
    public IndividuDto convertEntityToDto(IndividuEntity etudiantEntity){
        IndividuDto etudiantDto = new IndividuDto();
        etudiantDto.setNom(etudiantEntity.getNom());
       etudiantDto.setPrenom(etudiantEntity.getPrenom());
        return etudiantDto;
    }

    public IndividuEntity convertDtoToEntity(IndividuDto etudiantDto){
        IndividuEntity etudiantEntity = new IndividuEntity();
        etudiantEntity.setNom(etudiantDto.getNom());
        etudiantEntity.setPrenom(etudiantDto.getPrenom());
        etudiantEntity.setDateNaissance(etudiantDto.getDateNaissance());
        return etudiantEntity;
    }

    public IndividuDto saveEtudiant(IndividuDto etudiantDto){
               IndividuEntity etudiant = convertDtoToEntity(etudiantDto);
        return convertEntityToDto(etudiantRepository.save(etudiant)) ;
    }
    
    
    public List<IndividuDto> getListEtudiant(){
        return etudiantRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }


    public IndividuDto getEtudiantById(Long id){
        return convertEntityToDto(etudiantRepository.findById(id).get());
    }

    
    public void deleteEtudiantById(Long id){

      etudiantRepository.deleteById(id);
    }

    public IndividuDto updateEtudiant(IndividuDto etudiantDto,Long id){
        IndividuEntity etd=etudiantRepository.findById(id).get();

        

        if(Objects.nonNull(etudiantDto.getNom()) && !"".equalsIgnoreCase(etudiantDto.getPrenom())){
            etd.setNom(etudiantDto.getNom());
        }

        if(Objects.nonNull(etudiantDto.getPrenom())&& !"".equalsIgnoreCase(etudiantDto.getPrenom())){
            etd.setPrenom(etudiantDto.getPrenom());
        }

        if(Objects.nonNull(etudiantDto.getDateNaissance())){
            etd.setDateNaissance(etudiantDto.getDateNaissance());
        }

        return convertEntityToDto(etudiantRepository.save(etd));

    }
    
}
