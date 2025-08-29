package com.tech3.erp.repository;

import com.tech3.erp.entity.CurrencyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyMasterRepository extends JpaRepository<CurrencyMaster, Long> {
    Optional<CurrencyMaster> findByCurrencyCode(String currencyCode);
}
