package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.Flange;

import java.util.Optional;

@Repository
public interface FlangeRepository extends JpaRepository<Flange, Long> {
//    Optional<Flange> findByFlangNo(String flangeNo);
    
}
