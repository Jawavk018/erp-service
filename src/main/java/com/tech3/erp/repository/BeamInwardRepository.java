package com.tech3.erp.repository;

import com.tech3.erp.entity.BeamInward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeamInwardRepository extends JpaRepository<BeamInward, Long> {
}
