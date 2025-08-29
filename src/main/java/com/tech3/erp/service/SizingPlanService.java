package com.tech3.erp.service;

import com.tech3.erp.dto.SizingPlanDTO;
import com.tech3.erp.dto.SizingBeamDetailsDTO;
import com.tech3.erp.dto.SizingQualityDetailsDTO;
import com.tech3.erp.entity.SizingPlan;
import com.tech3.erp.entity.SizingBeamDetails;
import com.tech3.erp.entity.SizingQualityDetails;
import com.tech3.erp.repository.SizingPlanRepository;
import com.tech3.erp.repository.SizingBeamDetailsRepository;
import com.tech3.erp.repository.SizingQualityDetailsRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SizingPlanService {

    private final SizingPlanRepository sizingPlanRepository;
    private final SizingBeamDetailsRepository beamDetailsRepository;
    private final SizingQualityDetailsRepository qualityDetailsRepository;

    public SizingPlanService(
        SizingPlanRepository sizingPlanRepository,
        SizingBeamDetailsRepository beamDetailsRepository,
        SizingQualityDetailsRepository qualityDetailsRepository
    ) {
        this.sizingPlanRepository = sizingPlanRepository;
        this.beamDetailsRepository = beamDetailsRepository;
        this.qualityDetailsRepository = qualityDetailsRepository;
    }

    @Transactional
    public SizingPlanDTO saveSizingPlan(SizingPlanDTO dto) {
        SizingPlan plan = mapDtoToEntity(dto, new SizingPlan());
        final SizingPlan savedPlan = sizingPlanRepository.save(plan);

        List<SizingBeamDetails> beamEntities = dto.getSizingBeamDetails().stream().map(b -> {
            SizingBeamDetails beam = new SizingBeamDetails();
            beam.setSizingPlan(savedPlan);
            beam.setWeavingContractId(b.getWeavingContractId());
            beam.setSalesOrderId(b.getSalesOrderId());
            beam.setEmptyBeamId(b.getEmptyBeamId());
            beam.setWrapMeters(b.getWrapMeters());
            beam.setShrinkage(b.getShrinkage());
            beam.setExpectedFabricMeter(b.getExpectedFabricMeter());
            return beam;
        }).collect(Collectors.toList());
        beamDetailsRepository.saveAll(beamEntities);

        List<SizingQualityDetails> qualityEntities = dto.getSizingQualityDetails().stream().map(q -> {
            SizingQualityDetails quality = new SizingQualityDetails();
            quality.setSizingPlan(savedPlan);
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

        return getSizingPlanById(savedPlan.getId());
    }


    public List<SizingPlanDTO> getAllSizingPlans() {
        List<SizingPlan> plans = sizingPlanRepository.findAll();
        return plans.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public SizingPlanDTO getSizingPlanById(Long id) {
        SizingPlan plan = sizingPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SizingPlan not found with id: " + id));
        return mapEntityToDto(plan);
    }

    @Transactional
    public SizingPlanDTO updateSizingPlan(Long id, SizingPlanDTO dto) {
        SizingPlan existingPlan = sizingPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SizingPlan not found with id: " + id));

        mapDtoToEntity(dto, existingPlan);
        sizingPlanRepository.save(existingPlan);

        beamDetailsRepository.deleteBySizingPlanId(id);
        qualityDetailsRepository.deleteBySizingPlanId(id);

        List<SizingBeamDetails> beamEntities = dto.getSizingBeamDetails().stream().map(b -> {
            SizingBeamDetails beam = new SizingBeamDetails();
            beam.setSizingPlan(existingPlan);
            beam.setWeavingContractId(b.getWeavingContractId());
            beam.setSalesOrderId(b.getSalesOrderId());
            beam.setEmptyBeamId(b.getEmptyBeamId());
            beam.setWrapMeters(b.getWrapMeters());
            beam.setShrinkage(b.getShrinkage());
            beam.setExpectedFabricMeter(b.getExpectedFabricMeter());
            return beam;
        }).collect(Collectors.toList());
        beamDetailsRepository.saveAll(beamEntities);

        List<SizingQualityDetails> qualityEntities = dto.getSizingQualityDetails().stream().map(q -> {
            SizingQualityDetails quality = new SizingQualityDetails();
            quality.setSizingPlan(existingPlan);
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

        return getSizingPlanById(existingPlan.getId());
    }

//    @Transactional
//    public void deleteSizingPlan(Long id) {
//        SizingPlan plan = sizingPlanRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("SizingPlan not found with id: " + id));
//        beamDetailsRepository.deleteBySizingPlanId(id);
//        qualityDetailsRepository.deleteBySizingPlanId(id);
//        sizingPlanRepository.delete(plan);
//    }
    public void deleteSizingPlan(Long id) {
        // Check if category exists first
        if (!sizingPlanRepository.existsById(id)) {
            throw new EntityNotFoundException("SizingPlan not found with id: " + id);
        }   
        try {
        	sizingPlanRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete SizingPlan because it is referenced by other");
        }
    }

    // Helpers
    private SizingPlan mapDtoToEntity(SizingPlanDTO dto, SizingPlan plan) {
        plan.setVendorId(dto.getVendorId());
        plan.setTermsConditionsId(dto.getTermsConditionsId());
        plan.setConsigneeId(dto.getConsigneeId());
        plan.setPaymentTermsId(dto.getPaymentTermsId());
        plan.setSizingRate(dto.getSizingRate());
        plan.setRemarks(dto.getRemarks());
        plan.setSizingPlanNo(dto.getSizingPlanNo());
        return plan;
    }

    private SizingPlanDTO mapEntityToDto(SizingPlan plan) {
        SizingPlanDTO dto = new SizingPlanDTO();
        dto.setId(plan.getId());
        dto.setVendorId(plan.getVendorId());
        dto.setTermsConditionsId(plan.getTermsConditionsId());
        dto.setConsigneeId(plan.getConsigneeId());
        dto.setPaymentTermsId(plan.getPaymentTermsId());
        dto.setSizingRate(plan.getSizingRate());
        dto.setRemarks(plan.getRemarks());
        dto.setSizingPlanNo(plan.getSizingPlanNo());

        List<SizingBeamDetailsDTO> beamDtos = beamDetailsRepository.findBySizingPlanId(plan.getId()).stream().map(b -> {
            SizingBeamDetailsDTO bdto = new SizingBeamDetailsDTO();
            bdto.setId(b.getId());
            bdto.setWeavingContractId(b.getWeavingContractId());
            bdto.setSalesOrderId(b.getSalesOrderId());
            bdto.setEmptyBeamId(b.getEmptyBeamId());
            bdto.setWrapMeters(b.getWrapMeters());
            bdto.setShrinkage(b.getShrinkage());
            bdto.setExpectedFabricMeter(b.getExpectedFabricMeter());
            return bdto;
        }).collect(Collectors.toList());

        List<SizingQualityDetailsDTO> qualityDtos = qualityDetailsRepository.findBySizingPlanId(plan.getId()).stream().map(q -> {
            SizingQualityDetailsDTO qdto = new SizingQualityDetailsDTO();
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

        dto.setSizingBeamDetails(beamDtos);
        dto.setSizingQualityDetails(qualityDtos);

        return dto;
    }
}

