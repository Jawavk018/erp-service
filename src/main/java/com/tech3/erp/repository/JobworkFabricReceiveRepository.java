package com.tech3.erp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.JobworkFabricReceive;

@Repository
public interface JobworkFabricReceiveRepository extends JpaRepository<JobworkFabricReceive, Long> {
}
