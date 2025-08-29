package com.tech3.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.SizingYarnIssueDTO;
import com.tech3.erp.dto.SizingYarnIssueEntryDTO;
import com.tech3.erp.dto.SizingYarnRequirementDTO;
import com.tech3.erp.entity.SizingYarnIssue;
import com.tech3.erp.entity.SizingYarnIssueEntry;
import com.tech3.erp.entity.SizingYarnRequirement;
import com.tech3.erp.repository.SizingYarnIssueEntryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizingYarnIssueEntryService {

    @Autowired
    private SizingYarnIssueEntryRepository sizingYarnIssueEntryRepository;

    @Transactional(readOnly = true)
    public List<SizingYarnIssueEntryDTO> getAllSizingYarnIssueEntrys() {
        List<SizingYarnIssueEntry> issues = sizingYarnIssueEntryRepository.findAll();
        return issues.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public SizingYarnIssueEntryDTO createSizingYarnIssueEntry(SizingYarnIssueEntryDTO dto) {
    	SizingYarnIssueEntry issue = convertToEntity(dto);
    	SizingYarnIssueEntry savedIssue = sizingYarnIssueEntryRepository.save(issue);
        return convertToDTO(savedIssue);
    }

    private SizingYarnIssueEntryDTO convertToDTO(SizingYarnIssueEntry entity) {
    	SizingYarnIssueEntryDTO dto = new SizingYarnIssueEntryDTO();
        dto.setId(entity.getId());
        dto.setVendorId(entity.getVendorId());
        dto.setSizingPlanId(entity.getSizingPlanId());
        dto.setTransportationDetails(entity.getTransportationDetails());
        dto.setTermsConditionsId(entity.getTermsConditionsId());
        dto.setFabricDetails(entity.getFabricDetails());
        dto.setSizingYarnIssueDate(entity.getSizingYarnIssueDate());
        dto.setActiveFlag(entity.isActiveFlag());

        if (entity.getRequirements() != null) {
            List<SizingYarnRequirementDTO> requirementDTOs = entity.getRequirements().stream()
                    .map(this::convertRequirementToDTO)
                    .collect(Collectors.toList());
            dto.setRequirements(requirementDTOs);
        }
        
        if (entity.getSizingYarnIssues() != null) {
          List<SizingYarnIssueDTO> sizingYarnIssueDTOs = entity.getSizingYarnIssues().stream()
                  .map(this::convertYarnIssueToDTO)
                  .collect(Collectors.toList());
          dto.setSizingYarnIssue(sizingYarnIssueDTOs);
      }

        return dto;
    }

    private SizingYarnRequirementDTO convertRequirementToDTO(SizingYarnRequirement requirement) {
    	SizingYarnRequirementDTO dto = new SizingYarnRequirementDTO();
        dto.setId(requirement.getId());
        dto.setYarnName(requirement.getYarnName());
        dto.setYarnCount(requirement.getYarnCount());
        dto.setGramsPerMeter(requirement.getGramsPerMeter());
        dto.setTotalReqQty(requirement.getTotalReqQty());
        dto.setTotalIssueQty(requirement.getTotalIssueQty());
        dto.setBalanceToIssue(requirement.getBalanceToIssue());
        dto.setActiveFlag(requirement.isActiveFlag());

        return dto;
    }

    private SizingYarnIssueDTO convertYarnIssueToDTO(SizingYarnIssue sizingYarnIssue) {
    	SizingYarnIssueDTO dto = new SizingYarnIssueDTO();
        dto.setId(sizingYarnIssue.getId());
        dto.setLotId(sizingYarnIssue.getLotId());
        dto.setYarnName(sizingYarnIssue.getYarnName());
        dto.setAvailableReqQty(sizingYarnIssue.getAvailableReqQty());
        dto.setIssueQty(sizingYarnIssue.getIssueQty());
        dto.setActiveFlag(sizingYarnIssue.isActiveFlag());
        return dto;
    }

    private SizingYarnIssueEntry convertToEntity(SizingYarnIssueEntryDTO dto) {
    	SizingYarnIssueEntry entity = new SizingYarnIssueEntry();
        entity.setId(dto.getId());
        entity.setVendorId(dto.getVendorId());
        entity.setSizingPlanId(dto.getSizingPlanId());
        entity.setTransportationDetails(dto.getTransportationDetails());
        entity.setTermsConditionsId(dto.getTermsConditionsId());
        entity.setFabricDetails(dto.getFabricDetails());
        entity.setSizingYarnIssueDate(dto.getSizingYarnIssueDate());
        entity.setActiveFlag(dto.isActiveFlag());

        if (dto.getRequirements() != null) {
            List<SizingYarnRequirement> requirements = dto.getRequirements().stream()
                    .map(reqDTO -> {
                    	SizingYarnRequirement requirement = convertRequirementToEntity(reqDTO);
                        requirement.setSizingYarnIssueEntry(entity);
                        return requirement;
                    })
                    .collect(Collectors.toList());
            entity.setRequirements(requirements);
        }
        
        if (dto.getSizingYarnIssue() != null) {
            List<SizingYarnIssue> yarnIssues = dto.getSizingYarnIssue().stream()
                    .map(yarnDTO -> {
                        SizingYarnIssue yarnIssue = convertYarnIssueToEntity(yarnDTO);
                        yarnIssue.setSizingYarnIssueEntry(entity);
                        return yarnIssue;
                    })
                    .collect(Collectors.toList());
            entity.setSizingYarnIssues(yarnIssues);
        }

        return entity;
    }

    private SizingYarnRequirement convertRequirementToEntity(SizingYarnRequirementDTO dto) {
    	SizingYarnRequirement entity = new SizingYarnRequirement();
        entity.setId(dto.getId());
        entity.setYarnName(dto.getYarnName());
        entity.setYarnCount(dto.getYarnCount());
        entity.setGramsPerMeter(dto.getGramsPerMeter());
        entity.setTotalReqQty(dto.getTotalReqQty());
        entity.setTotalIssueQty(dto.getTotalIssueQty());
        entity.setBalanceToIssue(dto.getBalanceToIssue());
        entity.setActiveFlag(dto.isActiveFlag());

//        if (dto.getYarnIssues() != null) {
//            List<SizingYarnIssue> yarnIssues = dto.getYarnIssues().stream()
//                    .map(yarnDTO -> {
//                        YarnIssue yarnIssue = convertYarnIssueToEntity(yarnDTO);
//                        yarnIssue.setSizingYarnRequirement(entity);
//                        return yarnIssue;
//                    })
//                    .collect(Collectors.toList());
//            entity.setYarnIssues(yarnIssues);
//        }

        return entity;
    }

    private SizingYarnIssue convertYarnIssueToEntity(SizingYarnIssueDTO dto) {
    	SizingYarnIssue entity = new SizingYarnIssue();
        entity.setId(dto.getId());
        entity.setLotId(dto.getLotId());
        entity.setYarnName(dto.getYarnName());
        entity.setAvailableReqQty(dto.getAvailableReqQty());
        entity.setIssueQty(dto.getIssueQty());
        entity.setActiveFlag(dto.isActiveFlag());
        return entity;
    }

    // Other service methods...
}