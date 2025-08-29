package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.FabricCategory;

import java.util.Optional;

@Repository
public interface FabricCategoryRepository extends JpaRepository<FabricCategory, Long> {
    Optional<FabricCategory> findByFabricCategoryName(String fabricCategoryName);
}
