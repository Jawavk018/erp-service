package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.FabricInspection;

@Repository
public interface FabricInspectionRepository extends JpaRepository<FabricInspection, Long> {
}