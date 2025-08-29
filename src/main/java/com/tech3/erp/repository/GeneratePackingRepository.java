package com.tech3.erp.repository;

import com.tech3.erp.entity.GeneratePacking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratePackingRepository extends JpaRepository<GeneratePacking, Long> {
}