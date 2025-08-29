package com.tech3.erp.repository;

import com.tech3.erp.entity.ShipmentTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentTermsRepository extends JpaRepository<ShipmentTerms, Long> {
    Optional<ShipmentTerms> findByTermName(String termName);
}