package com.tech3.erp.repository;

import com.tech3.erp.entity.LotEntry;
import com.tech3.erp.entity.YarnMaster;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotEntryRepository extends JpaRepository<LotEntry, Long> {
}
