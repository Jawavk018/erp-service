package com.tech3.erp.repository;

import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.ShipmentMode;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentModeRepository extends JpaRepository<ShipmentMode, Long> {
    Optional<ShipmentMode> findByModeName(String ModeName);

}
