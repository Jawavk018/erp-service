package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.InspectionDetail;

@Repository
public interface InspectionDetailRepository extends JpaRepository<InspectionDetail, Long> {
    boolean existsByRollNo(String rollNo);
    InspectionDetail findByRollNo(String rollNo);
}