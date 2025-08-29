//package com.tech3.erp.service;
//
//import com.tech3.erp.dto.WeavingYarnIssueDTO;
//import com.tech3.erp.dto.WeavingYarnRequirementDTO;
//import com.tech3.erp.dto.YarnIssueDTO;
//import com.tech3.erp.entity.WeavingYarnIssue;
//import com.tech3.erp.entity.WeavingYarnRequirement;
//import com.tech3.erp.entity.YarnIssue;
//import com.tech3.erp.repository.WeavingYarnIssueRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class WeavingYarnIssueService {
//
//    @Autowired
//    private WeavingYarnIssueRepository weavingYarnIssueRepository;
//
//    @Transactional(readOnly = true)
//    public List<WeavingYarnIssueDTO> getAllWeavingYarnIssues() {
//        List<WeavingYarnIssue> issues = weavingYarnIssueRepository.findAll();
//        return issues.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public WeavingYarnIssueDTO createWeavingYarnIssue(WeavingYarnIssueDTO dto) {
//        WeavingYarnIssue issue = convertToEntity(dto);
//        WeavingYarnIssue savedIssue = weavingYarnIssueRepository.save(issue);
//        return convertToDTO(savedIssue);
//    }
//
//    private WeavingYarnIssueDTO convertToDTO(WeavingYarnIssue entity) {
//        WeavingYarnIssueDTO dto = new WeavingYarnIssueDTO();
//        dto.setId(entity.getId());
//        dto.setVendorId(entity.getVendorId());
//        dto.setWeavingContractId(entity.getWeavingContractId());
//        dto.setTransportationDetails(entity.getTransportationDetails());
//        dto.setTermsConditionsId(entity.getTermsConditionsId());
//        dto.setFabricDetails(entity.getFabricDetails());
//        dto.setYarnIssueDate(entity.getYarnIssueDate());
//        dto.setYarnIssueChallanNo(entity.getYarnIssueChallanNo());
//        dto.setActiveFlag(entity.isActiveFlag());
//
//        if (entity.getRequirements() != null) {
//            List<WeavingYarnRequirementDTO> requirementDTOs = entity.getRequirements().stream()
//                    .map(this::convertRequirementToDTO)
//                    .collect(Collectors.toList());
//            dto.setRequirements(requirementDTOs);
//        }
//
//        return dto;
//    }
//
//    private WeavingYarnRequirementDTO convertRequirementToDTO(WeavingYarnRequirement requirement) {
//        WeavingYarnRequirementDTO dto = new WeavingYarnRequirementDTO();
//        dto.setId(requirement.getId());
//        dto.setYarnName(requirement.getYarnName());
//        dto.setYarnCount(requirement.getYarnCount());
//        dto.setGramsPerMeter(requirement.getGramsPerMeter());
//        dto.setTotalReqQty(requirement.getTotalReqQty());
//        dto.setTotalIssueQty(requirement.getTotalIssueQty());
//        dto.setBalanceToIssue(requirement.getBalanceToIssue());
//        dto.setActiveFlag(requirement.isActiveFlag());
//
//        if (requirement.getYarnIssues() != null) {
//            List<YarnIssueDTO> yarnIssueDTOs = requirement.getYarnIssues().stream()
//                    .map(this::convertYarnIssueToDTO)
//                    .collect(Collectors.toList());
//            dto.setYarnIssues(yarnIssueDTOs);
//        }
//
//        return dto;
//    }
//
//    private YarnIssueDTO convertYarnIssueToDTO(YarnIssue yarnIssue) {
//        YarnIssueDTO dto = new YarnIssueDTO();
//        dto.setId(yarnIssue.getId());
//        dto.setLotId(yarnIssue.getLotId());
//        dto.setYarnName(yarnIssue.getYarnName());
//        dto.setAvailableReqQty(yarnIssue.getAvailableReqQty());
//        dto.setIssueQty(yarnIssue.getIssueQty());
//        dto.setActiveFlag(yarnIssue.isActiveFlag());
//        return dto;
//    }
//
//    private WeavingYarnIssue convertToEntity(WeavingYarnIssueDTO dto) {
//        WeavingYarnIssue entity = new WeavingYarnIssue();
//        entity.setId(dto.getId());
//        entity.setVendorId(dto.getVendorId());
//        entity.setWeavingContractId(dto.getWeavingContractId());
//        entity.setTransportationDetails(dto.getTransportationDetails());
//        entity.setTermsConditionsId(dto.getTermsConditionsId());
//        entity.setFabricDetails(dto.getFabricDetails());
//        entity.setYarnIssueDate(dto.getYarnIssueDate());
//        entity.setYarnIssueChallanNo(dto.getYarnIssueChallanNo());
//        entity.setActiveFlag(dto.isActiveFlag());
//
//        if (dto.getRequirements() != null) {
//            List<WeavingYarnRequirement> requirements = dto.getRequirements().stream()
//                    .map(reqDTO -> {
//                        WeavingYarnRequirement requirement = convertRequirementToEntity(reqDTO);
//                        requirement.setWeavingYarnIssue(entity);
//                        return requirement;
//                    })
//                    .collect(Collectors.toList());
//            entity.setRequirements(requirements);
//        }
//
//        return entity;
//    }
//
//    private WeavingYarnRequirement convertRequirementToEntity(WeavingYarnRequirementDTO dto) {
//        WeavingYarnRequirement entity = new WeavingYarnRequirement();
//        entity.setId(dto.getId());
//        entity.setYarnName(dto.getYarnName());
//        entity.setYarnCount(dto.getYarnCount());
//        entity.setGramsPerMeter(dto.getGramsPerMeter());
//        entity.setTotalReqQty(dto.getTotalReqQty());
//        entity.setTotalIssueQty(dto.getTotalIssueQty());
//        entity.setBalanceToIssue(dto.getBalanceToIssue());
//        entity.setActiveFlag(dto.isActiveFlag());
//
//        if (dto.getYarnIssues() != null) {
//            List<YarnIssue> yarnIssues = dto.getYarnIssues().stream()
//                    .map(yarnDTO -> {
//                        YarnIssue yarnIssue = convertYarnIssueToEntity(yarnDTO);
//                        yarnIssue.setWeavingYarnRequirement(entity);
//                        return yarnIssue;
//                    })
//                    .collect(Collectors.toList());
//            entity.setYarnIssues(yarnIssues);
//        }
//
//        return entity;
//    }
//
//    private YarnIssue convertYarnIssueToEntity(YarnIssueDTO dto) {
//        YarnIssue entity = new YarnIssue();
//        entity.setId(dto.getId());
//        entity.setLotId(dto.getLotId());
//        entity.setYarnName(dto.getYarnName());
//        entity.setAvailableReqQty(dto.getAvailableReqQty());
//        entity.setIssueQty(dto.getIssueQty());
//        entity.setActiveFlag(dto.isActiveFlag());
//        return entity;
//    }
//
//    // Other service methods...
//}




package com.tech3.erp.service;

import com.tech3.erp.dto.WeavingYarnIssueDTO;
import com.tech3.erp.dto.WeavingYarnRequirementDTO;
import com.tech3.erp.dto.YarnIssueDTO;
import com.tech3.erp.entity.LotEntry;
import com.tech3.erp.entity.LotOutward;
import com.tech3.erp.entity.WeavingYarnIssue;
import com.tech3.erp.entity.WeavingYarnRequirement;
import com.tech3.erp.entity.YarnIssue;
import com.tech3.erp.repository.LotEntryRepository;
import com.tech3.erp.repository.LotOutwardRepository;
import com.tech3.erp.repository.WeavingYarnIssueRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class WeavingYarnIssueService {

    @Autowired
    private WeavingYarnIssueRepository weavingYarnIssueRepository;
    
    @Autowired
    private LotEntryRepository lotEntryRepository;

    @Autowired  // Add this annotation
    private LotOutwardRepository lotOutwardRepository;
    
    // Get all issues
    @Transactional(readOnly = true)
    public List<WeavingYarnIssueDTO> getAllWeavingYarnIssues() {
        return weavingYarnIssueRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Create new issue with lot reduction
    public WeavingYarnIssueDTO createWeavingYarnIssue(WeavingYarnIssueDTO dto) {
        // Validate before processing
        validateYarnIssue(dto);
        
        // Convert to entity
        WeavingYarnIssue issue = convertToEntity(dto);
        
        // First save to get ID
        WeavingYarnIssue savedIssue = weavingYarnIssueRepository.save(issue);
        
        // Process lot reductions
//        processLotReductions(savedIssue);
        processLotOutward(savedIssue, "WEAVING_YARN_ISSUE", savedIssue.getId());
        
        // Return the saved DTO
        return convertToDTO(savedIssue);
    }

    // Update existing issue with lot adjustment
    public WeavingYarnIssueDTO updateWeavingYarnIssue(Long id, WeavingYarnIssueDTO dto) {
        // Validate before processing
        validateYarnIssue(dto);
        
        // Find existing issue
        WeavingYarnIssue existingIssue = weavingYarnIssueRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Weaving Yarn Issue not found"));
        
        // Reverse previous lot entries
        reverseLotReductions(existingIssue);
        
        // Update with new data
        WeavingYarnIssue updatedIssue = convertToEntity(dto);
        updatedIssue.setId(id);
        
        // Process new lot reductions
        processLotReductions(updatedIssue);
        
        // Save and return
        WeavingYarnIssue savedIssue = weavingYarnIssueRepository.save(updatedIssue);
        return convertToDTO(savedIssue);
    }

    // Delete issue with lot reversal
    public void deleteWeavingYarnIssue(Long id) {
        WeavingYarnIssue issue = weavingYarnIssueRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Weaving Yarn Issue not found"));
        
        // Reverse lot reductions
        reverseLotReductions(issue);
        
        // Delete the issue
        weavingYarnIssueRepository.delete(issue);
    }

    // ===== LOT QUANTITY MANAGEMENT =====
    
    private void processLotReductions(WeavingYarnIssue issue) {
        for (WeavingYarnRequirement requirement : issue.getRequirements()) {
            for (YarnIssue yarnIssue : requirement.getYarnIssues()) {
                reduceLotQuantity(yarnIssue.getLotId(), yarnIssue.getIssueQty());
            }
        }
    }

    private void reverseLotReductions(WeavingYarnIssue issue) {
        for (WeavingYarnRequirement requirement : issue.getRequirements()) {
            for (YarnIssue yarnIssue : requirement.getYarnIssues()) {
                restoreLotQuantity(yarnIssue.getLotId(), yarnIssue.getIssueQty());
            }
        }
    }
    
    private void processLotOutward(WeavingYarnIssue issue, String referenceType, Long referenceId) {
//        String currentUser = userService.getCurrentUsername();
        
        for (WeavingYarnRequirement requirement : issue.getRequirements()) {
            for (YarnIssue yarnIssue : requirement.getYarnIssues()) {
                // Reduce lot quantity
                LotEntry lot = reduceLotQuantity(yarnIssue.getLotId(), yarnIssue.getIssueQty());
                
                // Record outward entry
                LotOutward outward = new LotOutward();
                outward.setLotEntryId(yarnIssue.getLotId());
                outward.setOutwardType("YARN_ISSUE");
                outward.setReferenceType(referenceType);
                outward.setReferenceId(referenceId);
                outward.setQuantity(yarnIssue.getIssueQty());
                outward.setOutwardDate(issue.getYarnIssueDate());
                outward.setRemarks("Weaving yarn issue - " + issue.getYarnIssueChallanNo());
//                outward.setCreatedBy(currentUser);
                
                lotOutwardRepository.save(outward);
            }
        }
    }

    private LotEntry reduceLotQuantity(Long lotId, BigDecimal quantity) {
        LotEntry lot = lotEntryRepository.findById(lotId)
            .orElseThrow(() -> new EntityNotFoundException("Lot not found"));
        
        if (lot.getQuantity().compareTo(quantity) < 0) {
            throw new IllegalArgumentException(
                String.format("Not enough quantity in lot %s (Available: %s, Requested: %s)",
                    lot.getLotNumber(), lot.getQuantity(), quantity));
        }
        
        lot.setQuantity(lot.getQuantity().subtract(quantity));
        return lotEntryRepository.save(lot);
    }
    

//    private void reduceLotQuantity(Long lotId, BigDecimal quantityToReduce) {
//        LotEntry lot = lotEntryRepository.findById(lotId)
//            .orElseThrow(() -> new EntityNotFoundException("Lot not found"));
//        
//        if (lot.getQuantity().compareTo(quantityToReduce) < 0) {
//            throw new IllegalArgumentException(
//                String.format("Not enough quantity in lot %s (Available: %s, Requested: %s)",
//                    lot.getLotNumber(), lot.getQuantity(), quantityToReduce));
//        }
//        
//        lot.setQuantity(lot.getQuantity().subtract(quantityToReduce));
//        lotEntryRepository.save(lot);
//    }

    private void restoreLotQuantity(Long lotId, BigDecimal quantityToRestore) {
        LotEntry lot = lotEntryRepository.findById(lotId)
            .orElseThrow(() -> new EntityNotFoundException("Lot not found"));
        
        lot.setQuantity(lot.getQuantity().add(quantityToRestore));
        lotEntryRepository.save(lot);
    }

    // ===== VALIDATION =====
    
    private void validateYarnIssue(WeavingYarnIssueDTO dto) {
        // Validate total issue quantities
        for (WeavingYarnRequirementDTO req : dto.getRequirements()) {
            BigDecimal totalIssueQty = req.getYarnIssues().stream()
                .map(YarnIssueDTO::getIssueQty)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            if (totalIssueQty.compareTo(req.getTotalReqQty()) > 0) {
                throw new IllegalArgumentException(
                    "Total issue quantity exceeds required quantity for " + req.getYarnName());
            }
            
            // Validate individual lots
            for (YarnIssueDTO yarnIssue : req.getYarnIssues()) {
                LotEntry lot = lotEntryRepository.findById(yarnIssue.getLotId())
                    .orElseThrow(() -> new EntityNotFoundException(
                        "Lot not found: " + yarnIssue.getLotId()));
                
                if (lot.getQuantity().compareTo(yarnIssue.getIssueQty()) < 0) {
                    throw new IllegalArgumentException(
                        String.format("Insufficient quantity in lot %s (Available: %s, Requested: %s)",
                            lot.getLotNumber(), lot.getQuantity(), yarnIssue.getIssueQty()));
                }
            }
        }
    }

    // ===== CONVERSION METHODS =====
    // (Keep your existing conversion methods)
    private WeavingYarnIssueDTO convertToDTO(WeavingYarnIssue entity) {
        WeavingYarnIssueDTO dto = new WeavingYarnIssueDTO();
        dto.setId(entity.getId());
        dto.setVendorId(entity.getVendorId());
        dto.setWeavingContractId(entity.getWeavingContractId());
        dto.setTransportationDetails(entity.getTransportationDetails());
        dto.setTermsConditionsId(entity.getTermsConditionsId());
        dto.setFabricDetails(entity.getFabricDetails());
        dto.setYarnIssueDate(entity.getYarnIssueDate());
        dto.setYarnIssueChallanNo(entity.getYarnIssueChallanNo());
        dto.setActiveFlag(entity.isActiveFlag());

        if (entity.getRequirements() != null) {
            List<WeavingYarnRequirementDTO> requirementDTOs = entity.getRequirements().stream()
                    .map(this::convertRequirementToDTO)
                    .collect(Collectors.toList());
            dto.setRequirements(requirementDTOs);
        }

        return dto;
    }
    
    private WeavingYarnRequirementDTO convertRequirementToDTO(WeavingYarnRequirement requirement) {
        WeavingYarnRequirementDTO dto = new WeavingYarnRequirementDTO();
        dto.setId(requirement.getId());
        dto.setYarnName(requirement.getYarnName());
        dto.setYarnCount(requirement.getYarnCount());
        dto.setGramsPerMeter(requirement.getGramsPerMeter());
        dto.setTotalReqQty(requirement.getTotalReqQty());
        dto.setTotalIssueQty(requirement.getTotalIssueQty());
        dto.setBalanceToIssue(requirement.getBalanceToIssue());
        dto.setActiveFlag(requirement.isActiveFlag());

        if (requirement.getYarnIssues() != null) {
            List<YarnIssueDTO> yarnIssueDTOs = requirement.getYarnIssues().stream()
                    .map(this::convertYarnIssueToDTO)
                    .collect(Collectors.toList());
            dto.setYarnIssues(yarnIssueDTOs);
        }

        return dto;
    }
    
    private YarnIssueDTO convertYarnIssueToDTO(YarnIssue yarnIssue) {
        YarnIssueDTO dto = new YarnIssueDTO();
        dto.setId(yarnIssue.getId());
        dto.setLotId(yarnIssue.getLotId());
        dto.setYarnName(yarnIssue.getYarnName());
        dto.setAvailableReqQty(yarnIssue.getAvailableReqQty());
        dto.setIssueQty(yarnIssue.getIssueQty());
        dto.setActiveFlag(yarnIssue.isActiveFlag());
        return dto;
    }
    
    private WeavingYarnIssue convertToEntity(WeavingYarnIssueDTO dto) {
        WeavingYarnIssue entity = new WeavingYarnIssue();
        entity.setId(dto.getId());
        entity.setVendorId(dto.getVendorId());
        entity.setWeavingContractId(dto.getWeavingContractId());
        entity.setTransportationDetails(dto.getTransportationDetails());
        entity.setTermsConditionsId(dto.getTermsConditionsId());
        entity.setFabricDetails(dto.getFabricDetails());
        entity.setYarnIssueDate(dto.getYarnIssueDate());
        entity.setYarnIssueChallanNo(dto.getYarnIssueChallanNo());
        entity.setActiveFlag(dto.isActiveFlag());

        if (dto.getRequirements() != null) {
            List<WeavingYarnRequirement> requirements = dto.getRequirements().stream()
                    .map(reqDTO -> {
                        WeavingYarnRequirement requirement = convertRequirementToEntity(reqDTO);
                        requirement.setWeavingYarnIssue(entity);
                        return requirement;
                    })
                    .collect(Collectors.toList());
            entity.setRequirements(requirements);
        }

        return entity;
    }
    
    private WeavingYarnRequirement convertRequirementToEntity(WeavingYarnRequirementDTO dto) {
        WeavingYarnRequirement entity = new WeavingYarnRequirement();
        entity.setId(dto.getId());
        entity.setYarnName(dto.getYarnName());
        entity.setYarnCount(dto.getYarnCount());
        entity.setGramsPerMeter(dto.getGramsPerMeter());
        entity.setTotalReqQty(dto.getTotalReqQty());
        entity.setTotalIssueQty(dto.getTotalIssueQty());
        entity.setBalanceToIssue(dto.getBalanceToIssue());
        entity.setActiveFlag(dto.isActiveFlag());

        if (dto.getYarnIssues() != null) {
            List<YarnIssue> yarnIssues = dto.getYarnIssues().stream()
                    .map(yarnDTO -> {
                        YarnIssue yarnIssue = convertYarnIssueToEntity(yarnDTO);
                        yarnIssue.setWeavingYarnRequirement(entity);
                        return yarnIssue;
                    })
                    .collect(Collectors.toList());
            entity.setYarnIssues(yarnIssues);
        }

        return entity;
    }
    
    private YarnIssue convertYarnIssueToEntity(YarnIssueDTO dto) {
        YarnIssue entity = new YarnIssue();
        entity.setId(dto.getId());
        entity.setLotId(dto.getLotId());
        entity.setYarnName(dto.getYarnName());
        entity.setAvailableReqQty(dto.getAvailableReqQty());
        entity.setIssueQty(dto.getIssueQty());
        entity.setActiveFlag(dto.isActiveFlag());
        return entity;
    }
}





