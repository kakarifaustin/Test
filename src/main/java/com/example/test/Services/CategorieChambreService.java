package com.example.test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.ConvertDTO.CategorieChambreConvertDTO;
import com.example.test.Dto.CategorieChambreDTO;
import com.example.test.repositories.CategorieChambreRepository;

@Service
public class CategorieChambreService {

    @Autowired
    private CategorieChambreRepository categorieChambreRepository;


    public void enregistrerCategorieChambre(CategorieChambreDTO categorieChambreDTO){
        // categorieChambreRepository.save(CategorieChambreConvertDTO.getInstance().convertEntityToDTO(categorieChambreEntity));

    }
}
