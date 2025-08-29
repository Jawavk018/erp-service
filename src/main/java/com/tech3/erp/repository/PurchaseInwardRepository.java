package com.tech3.erp.repository;

import com.tech3.erp.entity.PurchaseInward;
import com.tech3.erp.entity.YarnMaster;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInwardRepository extends JpaRepository<PurchaseInward, Long> {
}
