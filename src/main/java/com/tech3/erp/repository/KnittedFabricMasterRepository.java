package com.tech3.erp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tech3.erp.entity.KnittedFabricMaster;

public interface KnittedFabricMasterRepository extends JpaRepository<KnittedFabricMaster, Long> {

//    List<KnittedFabricMaster> findByFabricDetailsFabricTypeId(Short fabricTypeId);    
}