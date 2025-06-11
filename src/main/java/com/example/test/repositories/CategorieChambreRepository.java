package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.Entities.CategorieChambreEntity;

@Repository
public interface CategorieChambreRepository extends JpaRepository<CategorieChambreEntity,Long> {


    
}
