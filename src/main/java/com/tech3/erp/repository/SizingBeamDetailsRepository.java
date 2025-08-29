package com.tech3.erp.repository;

import com.tech3.erp.entity.SizingBeamDetails;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizingBeamDetailsRepository extends JpaRepository<SizingBeamDetails, Long> {

	List<SizingBeamDetails> findBySizingPlanId(Long sizingPlanId);
	void deleteBySizingPlanId(Long sizingPlanId);}
