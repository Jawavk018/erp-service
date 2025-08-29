package com.tech3.erp.service;

import com.tech3.erp.dto.FabricCategoryDTO;
import com.tech3.erp.entity.FabricCategory;
import com.tech3.erp.repository.FabricCategoryRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class FabricCategoryService {

    private final FabricCategoryRepository fabricCategoryRepository;

    public FabricCategoryService(FabricCategoryRepository fabricCategoryRepository) {
        this.fabricCategoryRepository = fabricCategoryRepository;
    }

    public FabricCategoryDTO createFabricCategory(FabricCategoryDTO fabricCategoryDTO) {
        FabricCategory fabricCategory = new FabricCategory();
        fabricCategory.setFabricCategoryName(fabricCategoryDTO.getFabricCategoryName());
        fabricCategory.setActiveFlag(fabricCategoryDTO.getActiveFlag());

		return new FabricCategoryDTO(fabricCategoryRepository.save(fabricCategory));
    }

    public FabricCategoryDTO getFabricCategoryById(Long id) {
        FabricCategory fabricCategory = fabricCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fabric Category not found"));
        return new FabricCategoryDTO(fabricCategory);
    }

    public List<FabricCategoryDTO> getAllFabricCategory() {
        return fabricCategoryRepository.findAll()
                .stream()
                .map(FabricCategoryDTO::new)
                .collect(Collectors.toList());
    }

    public FabricCategoryDTO updateFabricCategory(Long id, FabricCategoryDTO fabricCategoryDTO) {
        FabricCategory fabricCategory = fabricCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fabric category not found"));

        fabricCategory.setFabricCategoryName(fabricCategoryDTO.getFabricCategoryName());
        fabricCategory.setActiveFlag(fabricCategoryDTO.getActiveFlag());

        return new FabricCategoryDTO(fabricCategoryRepository.save(fabricCategory));
    }
    
//    public void deleteFabricCategory(Long id) {
//        if (!fabricCategoryRepository.existsById(id)) {
//            throw new IllegalArgumentException("Fabric type not found");
//        }
//        fabricCategoryRepository.deleteById(id);
//    }
    
    public void deleteFabricCategory(Long id) {
        // Check if category exists first
        if (!fabricCategoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Fabric Category not found with id: " + id);
        }
        
        try {
        	fabricCategoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Fabric Category because it is referenced by other");
        }
    }
    
}
