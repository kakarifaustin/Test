package com.example.test.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.Entities.Hotel;

@Repository
public interface hotelRepository extends JpaRepository<Hotel,Long>{
    
}
