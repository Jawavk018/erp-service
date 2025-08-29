package com.tech3.erp.repository;

import com.tech3.erp.entity.FabricType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FabricTypeRepository extends JpaRepository<FabricType, Long> {
    Optional<FabricType> findByFabricTypeName(String fabricTypeName);
}
