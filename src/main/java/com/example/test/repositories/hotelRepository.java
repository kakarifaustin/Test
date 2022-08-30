package com.example.test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.test.Entities.hotel;

public interface hotelRepository extends JpaRepository<hotel,Long>{

    @Query("SELECT * FROM hotel h WHERE h.code=?1")
    Optional<hotel>findHotelByCode(String code);
    
}
