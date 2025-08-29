package com.tech3.erp.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.BeamInwardQualityDetails;

@Repository
public interface BeamInwardQualityDetailsRepository extends JpaRepository<BeamInwardQualityDetails, Long> {

	List<BeamInwardQualityDetails> findByBeamInwardId(Long beamInwardId);
	void deleteByBeamInwardId(Long beamInwardId);}
