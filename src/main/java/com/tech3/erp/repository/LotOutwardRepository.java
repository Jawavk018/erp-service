package com.tech3.erp.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tech3.erp.entity.LotOutward;

public interface LotOutwardRepository extends JpaRepository<LotOutward, Long> {
    
    List<LotOutward> findByLotEntryId(Long lotEntryId);
    
    List<LotOutward> findByReferenceTypeAndReferenceId(String referenceType, Long referenceId);
    
    @Query("SELECT SUM(lo.quantity) FROM LotOutward lo WHERE lo.lotEntryId = :lotEntryId AND lo.activeFlag = true")
    BigDecimal getTotalOutwardQuantityByLotEntry(@Param("lotEntryId") Long lotEntryId);
}