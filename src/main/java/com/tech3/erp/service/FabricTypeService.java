package com.tech3.erp.service;

import com.tech3.erp.dto.FabricTypeDTO;
import com.tech3.erp.entity.FabricType;
import com.tech3.erp.repository.FabricTypeRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricTypeService {

    private final FabricTypeRepository fabricTypeRepository;

    public FabricTypeService(FabricTypeRepository fabricTypeRepository) {
        this.fabricTypeRepository = fabricTypeRepository;
    }

    public FabricTypeDTO createFabricType(FabricTypeDTO fabricTypeDTO) {
        FabricType fabricType = new FabricType();
        fabricType.setFabricTypeName(fabricTypeDTO.getFabricTypeName());
        fabricType.setActiveFlag(fabricTypeDTO.getActiveFlag());

        return new FabricTypeDTO(fabricTypeRepository.save(fabricType));
    }

    public FabricTypeDTO getFabricTypeById(Long id) {
        FabricType fabricType = fabricTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fabric type not found"));
        return new FabricTypeDTO(fabricType);
    }

    public List<FabricTypeDTO> getAllFabricTypes() {
        return fabricTypeRepository.findAll()
                .stream()
                .map(FabricTypeDTO::new)
                .collect(Collectors.toList());
    }

    public FabricTypeDTO updateFabricType(Long id, FabricTypeDTO fabricTypeDTO) {
        FabricType fabricType = fabricTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fabric type not found"));

        fabricType.setFabricTypeName(fabricTypeDTO.getFabricTypeName());
        fabricType.setActiveFlag(fabricTypeDTO.getActiveFlag());

        return new FabricTypeDTO(fabricTypeRepository.save(fabricType));
    }
    
//    public void deleteFabricType(Long id) {
//        if (!fabricTypeRepository.existsById(id)) {
//            throw new IllegalArgumentException("Fabric type not found");
//        }
//        fabricTypeRepository.deleteById(id);
//    }
    
    public void deleteFabricType(Long id) {
        // Check if category exists first
        if (!fabricTypeRepository.existsById(id)) {
            throw new EntityNotFoundException("FabricType not found with id: " + id);
        }
        
        try {
        	fabricTypeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete FabricType because it is referenced by other");
        }
    }
}
