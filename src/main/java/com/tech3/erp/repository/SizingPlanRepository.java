package com.tech3.erp.repository;

import com.tech3.erp.entity.SizingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizingPlanRepository extends JpaRepository<SizingPlan, Long> {
}
