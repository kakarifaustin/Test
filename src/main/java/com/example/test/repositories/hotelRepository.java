package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.Entities.hotel;

public interface hotelRepository extends JpaRepository<hotel,Integer>{
    
}
