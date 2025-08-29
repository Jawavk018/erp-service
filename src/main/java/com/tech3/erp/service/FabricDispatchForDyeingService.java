package com.tech3.erp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.FabricDispatchForDyeingDTO;
import com.tech3.erp.entity.FabricDispatchForDyeing;
import com.tech3.erp.repository.FabricDispatchForDyeingRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FabricDispatchForDyeingService {

    @Autowired
    private FabricDispatchForDyeingRepository repository;

    // Convert Entity to DTO
    private FabricDispatchForDyeingDTO convertToDTO(FabricDispatchForDyeing entity) {
        return new FabricDispatchForDyeingDTO(
                entity.getId(),
                entity.getFabricDispatchDate(),
                entity.getVendorId(),
                entity.getDyeingWorkOrderId(),
                entity.getOrderQuantity(),
                entity.getDispatchedQuantity(),
                entity.getReceivedQuantity(),
                entity.getBalanceQuantity(),
                entity.getCostPerPound(),
                entity.getTotalAmount(),
                entity.getColorId(),
                entity.getPantone(),
                entity.getFinishingId(),
                entity.getSalesOrderId(),
                entity.getShipmentModeId(),
                entity.getLotId(),
                entity.getRemarks(),
                entity.getActiveFlag()
        );
    }

    // Convert DTO to Entity
    private FabricDispatchForDyeing convertToEntity(FabricDispatchForDyeingDTO dto) {
        return new FabricDispatchForDyeing(
                dto.getId(),
                dto.getFabricDispatchDate(),
                dto.getVendorId(),
                dto.getDyeingWorkOrderId(),
                dto.getOrderQuantity(),
                dto.getDispatchedQuantity(),
                dto.getReceivedQuantity(),
                dto.getBalanceQuantity(),
                dto.getCostPerPound(),
                dto.getTotalAmount(),
                dto.getColorId(),
                dto.getPantone(),
                dto.getFinishingId(),
                dto.getSalesOrderId(),
                dto.getShipmentModeId(),
                dto.getLotId(),
                dto.getRemarks(),
                dto.getActiveFlag()
        );
    }

    // CREATE
    public FabricDispatchForDyeingDTO createDispatch(FabricDispatchForDyeingDTO dto) {
        FabricDispatchForDyeing entity = repository.save(convertToEntity(dto));
        return convertToDTO(entity);
    }

    // READ ALL
    public List<FabricDispatchForDyeingDTO> getAllDispatches() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // READ BY ID
    public Optional<FabricDispatchForDyeingDTO> getDispatchById(Long id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // UPDATE
    public FabricDispatchForDyeingDTO updateDispatch(Long id, FabricDispatchForDyeingDTO dto) {
        if (repository.existsById(id)) {
            dto.setId(id);
            FabricDispatchForDyeing entity = repository.save(convertToEntity(dto));
            return convertToDTO(entity);
        }
        return null;
    }

    // DELETE
//    public boolean deleteDispatch(Long id) {
//        if (repository.existsById(id)) {
//            repository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
    public void deleteDispatch(Long id) {
        // Check if category exists first
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Fabric Dispatch not found with id: " + id);
        }   
        try {
        	repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Fabric Dispatch because it is referenced by other");
        }
    }
    
}
