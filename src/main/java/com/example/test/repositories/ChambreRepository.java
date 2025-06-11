package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test.Entities.ChambreEntity;

public interface ChambreRepository extends JpaRepository<ChambreEntity,Long>{
    
}
