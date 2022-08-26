package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.Entities.personneEntity;

@Repository
public interface personneRespository extends JpaRepository<personneEntity,Long>{

    
}
