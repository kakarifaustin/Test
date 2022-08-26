package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.Entities.IndividuEntity;

@Repository
public interface IndividuRepository extends JpaRepository<IndividuEntity,Long> {
    
}
