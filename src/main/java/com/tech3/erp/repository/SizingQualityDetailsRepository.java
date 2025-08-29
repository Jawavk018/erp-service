package com.tech3.erp.repository;

import com.tech3.erp.entity.SizingBeamDetails;
import com.tech3.erp.entity.SizingQualityDetails;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizingQualityDetailsRepository extends JpaRepository<SizingQualityDetails, Long> {

	List<SizingQualityDetails> findBySizingPlanId(Long sizingPlanId);
	void deleteBySizingPlanId(Long sizingPlanId);}
