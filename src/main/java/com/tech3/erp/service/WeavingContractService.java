package com.tech3.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.WeavingContractDTO;
import com.tech3.erp.entity.WeavingContract;
import com.tech3.erp.entity.WeavingContractItem;
import com.tech3.erp.entity.YarnRequirement;
import com.tech3.erp.repository.WeavingContractRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeavingContractService {

    @Autowired
    private WeavingContractRepository contractRepo;

    public WeavingContract createWeavingContract(WeavingContractDTO dto) {
        WeavingContract contract = new WeavingContract();
        contract.setSalesOrderNo(dto.getSalesOrderNo());
        contract.setVendorId(dto.getVendorId());
        contract.setTermsConditionsId(dto.getTermsConditionsId());
        contract.setPaymentTermsId(dto.getPaymentTermsId());
        contract.setRemarks(dto.getRemarks());

        List<WeavingContractItem> items = dto.getItems().stream().map(itemDTO -> {
            WeavingContractItem item = new WeavingContractItem();
            item.setFabricCodeId(itemDTO.getFabricCodeId());
            item.setFabricQualityId(itemDTO.getFabricQualityId());
            item.setQuantity(itemDTO.getQuantity());
            item.setPickCost(itemDTO.getPickCost());
            item.setPlannedStartDate(itemDTO.getPlannedStartDate());
            item.setPlannedEndDate(itemDTO.getPlannedEndDate());
            item.setDailyTarget(itemDTO.getDailyTarget());
            item.setNumberOfLooms(itemDTO.getNumberOfLooms());
            item.setWarpLength(itemDTO.getWarpLength());
            item.setWarpCrimpPercentage(itemDTO.getWarpCrimpPercentage());
            item.setPieceLength(itemDTO.getPieceLength());
            item.setNumberOfPieces(itemDTO.getNumberOfPieces());
            item.setWeavingContract(contract);
            return item;
        }).collect(Collectors.toList());

        List<YarnRequirement> yarns = dto.getYarnRequirements().stream().map(yarnDTO -> {
            YarnRequirement yr = new YarnRequirement();
            yr.setYarnType(yarnDTO.getYarnType());
            yr.setYarnCount(yarnDTO.getYarnCount());
            yr.setGramsPerMeter(yarnDTO.getGramsPerMeter());
            yr.setTotalWeavingOrderQty(yarnDTO.getTotalWeavingOrderQty());
            yr.setTotalRequiredQty(yarnDTO.getTotalRequiredQty());
            yr.setTotalAvailableQty(yarnDTO.getTotalAvailableQty());
            yr.setWeavingContract(contract);
            return yr;
        }).collect(Collectors.toList());

        contract.setItems(items);
        contract.setYarnRequirements(yarns);

        return contractRepo.save(contract);
    }
    
    // Get all WeavingContract records
    public List<WeavingContract> getAllWeavingContract() {
        return contractRepo.findAll();
    }
    
    // Get a WeavingContract by ID
    public WeavingContract getWeavingContractById(Long id) {
        return contractRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WeavingContract not found with id: " + id));
    }
    
    public WeavingContract updateWeavingContract(Long id, WeavingContractDTO dto) {
        WeavingContract contract = contractRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WeavingContract not found with id: " + id));
        contract.setSalesOrderNo(dto.getSalesOrderNo());
        contract.setVendorId(dto.getVendorId());
        contract.setTermsConditionsId(dto.getTermsConditionsId());
        contract.setPaymentTermsId(dto.getPaymentTermsId());
        contract.setRemarks(dto.getRemarks());

        contract.getItems().clear();
        List<WeavingContractItem> items = dto.getItems().stream().map(itemDTO -> {
            WeavingContractItem item = new WeavingContractItem();
            item.setFabricCodeId(itemDTO.getFabricCodeId());
            item.setFabricQualityId(itemDTO.getFabricQualityId());
            item.setQuantity(itemDTO.getQuantity());
            item.setPickCost(itemDTO.getPickCost());
            item.setPlannedStartDate(itemDTO.getPlannedStartDate());
            item.setPlannedEndDate(itemDTO.getPlannedEndDate());
            item.setDailyTarget(itemDTO.getDailyTarget());
            item.setNumberOfLooms(itemDTO.getNumberOfLooms());
            item.setWarpLength(itemDTO.getWarpLength());
            item.setWarpCrimpPercentage(itemDTO.getWarpCrimpPercentage());
            item.setPieceLength(itemDTO.getPieceLength());
            item.setNumberOfPieces(itemDTO.getNumberOfPieces());
            item.setWeavingContract(contract);
            return item;
        }).collect(Collectors.toList());
        contract.getItems().addAll(items);

        contract.getYarnRequirements().clear();
        List<YarnRequirement> yarns = dto.getYarnRequirements().stream().map(yarnDTO -> {
            YarnRequirement yr = new YarnRequirement();
            yr.setYarnType(yarnDTO.getYarnType());
            yr.setYarnCount(yarnDTO.getYarnCount());
            yr.setGramsPerMeter(yarnDTO.getGramsPerMeter());
            yr.setTotalWeavingOrderQty(yarnDTO.getTotalWeavingOrderQty());
            yr.setTotalRequiredQty(yarnDTO.getTotalRequiredQty());
            yr.setTotalAvailableQty(yarnDTO.getTotalAvailableQty());
            yr.setWeavingContract(contract);
            return yr;
        }).collect(Collectors.toList());
        contract.getYarnRequirements().addAll(yarns);

        return contractRepo.save(contract);
    }

    // Delete a WeavingContract by ID (Soft Delete or Physical Delete)
//    public void deleteContract(Long id) {
//        if (!contractRepo.existsById(id)) {
//            throw new EntityNotFoundException("WeavingContract not found with id: " + id);
//        }
//        contractRepo.deleteById(id);
//    }
    
    public void deleteWeavingContract(Long id) {
        // Check if category exists first
        if (!contractRepo.existsById(id)) {
            throw new EntityNotFoundException("Weaving Contract not found with id: " + id);
        }
        
        try {
        	contractRepo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Weaving Contract because it is referenced by other");
        }
    }

}
