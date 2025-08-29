package com.tech3.erp.service;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.BeamInwardBeamDetailsDTO;
import com.tech3.erp.dto.BeamInwardDTO;
import com.tech3.erp.dto.BeamInwardQualityDetailsDTO;
import com.tech3.erp.entity.BeamInward;
import com.tech3.erp.entity.BeamInwardBeamDetails;
import com.tech3.erp.entity.BeamInwardQualityDetails;
import com.tech3.erp.repository.BeamInwardBeamDetailsRepository;
import com.tech3.erp.repository.BeamInwardQualityDetailsRepository;
import com.tech3.erp.repository.BeamInwardRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class BeamInwardService {

    private final BeamInwardRepository beamInwardRepository;
    private final BeamInwardBeamDetailsRepository beamDetailsRepository;
    private final BeamInwardQualityDetailsRepository qualityDetailsRepository;

    public BeamInwardService(
    		BeamInwardRepository beamInwardRepository,
    		BeamInwardBeamDetailsRepository beamDetailsRepository,
    		BeamInwardQualityDetailsRepository qualityDetailsRepository
    ) {
        this.beamInwardRepository = beamInwardRepository;
        this.beamDetailsRepository = beamDetailsRepository;
        this.qualityDetailsRepository = qualityDetailsRepository;
    }

    @Transactional
    public BeamInwardDTO saveBeamInward(BeamInwardDTO dto) {
    	BeamInward plan = mapDtoToEntity(dto, new BeamInward());
        final BeamInward savedBeamInward = beamInwardRepository.save(plan);

        List<BeamInwardBeamDetails> beamEntities = dto.getBeamInwardBeamDetails().stream().map(b -> {
            BeamInwardBeamDetails beam = new BeamInwardBeamDetails();
            beam.setBeamInward(savedBeamInward);
            beam.setWeavingContractId(b.getWeavingContractId());
            beam.setSalesOrderId(b.getSalesOrderId());
            beam.setEmptyBeamId(b.getEmptyBeamId());
            beam.setWrapMeters(b.getWrapMeters());
            beam.setShrinkage(b.getShrinkage());
            beam.setExpectedFabricMeter(b.getExpectedFabricMeter());
            return beam;
        }).collect(Collectors.toList());
        beamDetailsRepository.saveAll(beamEntities);

        List<BeamInwardQualityDetails> qualityEntities = dto.getBeamInwardQualityDetails().stream().map(q -> {
            BeamInwardQualityDetails quality = new BeamInwardQualityDetails();
            quality.setBeamInward(savedBeamInward);
            quality.setQuality(q.getQuality());
            quality.setYarnId(q.getYarnId());
            quality.setSordEnds(q.getSordEnds());
            quality.setActualEnds(q.getActualEnds());
            quality.setParts(q.getParts());
            quality.setEndsPerPart(q.getEndsPerPart());
            quality.setWrapMeters(q.getWrapMeters());
            return quality;
        }).collect(Collectors.toList());
        qualityDetailsRepository.saveAll(qualityEntities);

        return getBeamInwardById(savedBeamInward.getId());
    }


    public List<BeamInwardDTO> getAllBeamInward() {
        List<BeamInward> plans = beamInwardRepository.findAll();
        return plans.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public BeamInwardDTO getBeamInwardById(Long id) {
    	BeamInward plan = beamInwardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BeamInward not found with id: " + id));
        return mapEntityToDto(plan);
    }

    @Transactional
    public BeamInwardDTO updateBeamInward(Long id, BeamInwardDTO dto) {
    	BeamInward existingPlan = beamInwardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BeamInward not found with id: " + id));

        mapDtoToEntity(dto, existingPlan);
        beamInwardRepository.save(existingPlan);

        beamDetailsRepository.deleteByBeamInwardId(id);
        qualityDetailsRepository.deleteByBeamInwardId(id);

        List<BeamInwardBeamDetails> beamEntities = dto.getBeamInwardBeamDetails().stream().map(b -> {
        	BeamInwardBeamDetails beam = new BeamInwardBeamDetails();
            beam.setBeamInward(existingPlan);
            beam.setWeavingContractId(b.getWeavingContractId());
            beam.setSalesOrderId(b.getSalesOrderId());
            beam.setEmptyBeamId(b.getEmptyBeamId());
            beam.setWrapMeters(b.getWrapMeters());
            beam.setShrinkage(b.getShrinkage());
            beam.setExpectedFabricMeter(b.getExpectedFabricMeter());
            return beam;
        }).collect(Collectors.toList());
        beamDetailsRepository.saveAll(beamEntities);

        List<BeamInwardQualityDetails> qualityEntities = dto.getBeamInwardQualityDetails().stream().map(q -> {
        	BeamInwardQualityDetails quality = new BeamInwardQualityDetails();
            quality.setBeamInward(existingPlan);
            quality.setQuality(q.getQuality());
            quality.setYarnId(q.getYarnId());
            quality.setSordEnds(q.getSordEnds());
            quality.setActualEnds(q.getActualEnds());
            quality.setParts(q.getParts());
            quality.setEndsPerPart(q.getEndsPerPart());
            quality.setWrapMeters(q.getWrapMeters());
            return quality;
        }).collect(Collectors.toList());
        qualityDetailsRepository.saveAll(qualityEntities);

        return getBeamInwardById(existingPlan.getId());
    }

//    @Transactional
//    public void deleteSizingPlan(Long id) {
//        SizingPlan plan = beamInwardRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("SizingPlan not found with id: " + id));
//        beamDetailsRepository.deleteBySizingPlanId(id);
//        qualityDetailsRepository.deleteBySizingPlanId(id);
//        beamInwardRepository.delete(plan);
//    }
    public void deleteBeamInward(Long id) {
        // Check if category exists first
        if (!beamInwardRepository.existsById(id)) {
            throw new EntityNotFoundException("Beam Inward not found with id: " + id);
        }   
        try {
        	beamInwardRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Beam Inward because it is referenced by other");
        }
    }

    // Helpers
    private BeamInward mapDtoToEntity(BeamInwardDTO dto, BeamInward plan) {
        plan.setVendorId(dto.getVendorId());
        plan.setTermsConditionsId(dto.getTermsConditionsId());
        plan.setConsigneeId(dto.getConsigneeId());
        plan.setPaymentTermsId(dto.getPaymentTermsId());
        plan.setSizingRate(dto.getSizingRate());
        plan.setRemarks(dto.getRemarks());
        plan.setBeamInwardNo(dto.getBeamInwardNo());
        return plan;
    }

    private BeamInwardDTO mapEntityToDto(BeamInward plan) {
    	BeamInwardDTO dto = new BeamInwardDTO();
        dto.setId(plan.getId());
        dto.setVendorId(plan.getVendorId());
        dto.setTermsConditionsId(plan.getTermsConditionsId());
        dto.setConsigneeId(plan.getConsigneeId());
        dto.setPaymentTermsId(plan.getPaymentTermsId());
        dto.setSizingRate(plan.getSizingRate());
        dto.setRemarks(plan.getRemarks());
        dto.setBeamInwardNo(plan.getBeamInwardNo());

        List<BeamInwardBeamDetailsDTO> beamDtos = beamDetailsRepository.findByBeamInwardId(plan.getId()).stream().map(b -> {
        	BeamInwardBeamDetailsDTO bdto = new BeamInwardBeamDetailsDTO();
            bdto.setId(b.getId());
            bdto.setWeavingContractId(b.getWeavingContractId());
            bdto.setSalesOrderId(b.getSalesOrderId());
            bdto.setEmptyBeamId(b.getEmptyBeamId());
            bdto.setWrapMeters(b.getWrapMeters());
            bdto.setShrinkage(b.getShrinkage());
            bdto.setExpectedFabricMeter(b.getExpectedFabricMeter());
            return bdto;
        }).collect(Collectors.toList());

        List<BeamInwardQualityDetailsDTO> qualityDtos = qualityDetailsRepository.findByBeamInwardId(plan.getId()).stream().map(q -> {
        	BeamInwardQualityDetailsDTO qdto = new BeamInwardQualityDetailsDTO();
            qdto.setId(q.getId());
            qdto.setQuality(q.getQuality());
            qdto.setYarnId(q.getYarnId());
            qdto.setSordEnds(q.getSordEnds());
            qdto.setActualEnds(q.getActualEnds());
            qdto.setParts(q.getParts());
            qdto.setEndsPerPart(q.getEndsPerPart());
            qdto.setWrapMeters(q.getWrapMeters());
            return qdto;
        }).collect(Collectors.toList());

        dto.setBeamInwardBeamDetails(beamDtos);
        dto.setBeamInwardQualityDetails(qualityDtos);

        return dto;
    }

}

