package com.tech3.erp.repository;

import com.tech3.erp.entity.YarnMaster;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YarnMasterRepository extends JpaRepository<YarnMaster, Long> {
    Optional<YarnMaster> findByYarnName(String YarnName);
}