package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.GstMaster;

@Repository
public interface GstMasterRepository extends JpaRepository<GstMaster, Long> {}