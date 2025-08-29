package com.tech3.erp.service;

import com.tech3.erp.dto.YarnMasterDTO;
import com.tech3.erp.entity.YarnMaster;
import com.tech3.erp.repository.YarnMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class YarnMasterService {

    private final YarnMasterRepository yarnMasterRepository;

    public YarnMasterService(YarnMasterRepository yarnMasterRepository) {
        this.yarnMasterRepository = yarnMasterRepository;
    }

    // Create a new YarnMaster
    public YarnMasterDTO createYarnMaster(YarnMasterDTO yarnMasterDTO) {
        YarnMaster yarnMaster = new YarnMaster();
        yarnMaster.setYarnName(yarnMasterDTO.getYarnName());
        yarnMaster.setCountSno(yarnMasterDTO.getCountSno());
        yarnMaster.setUnitSno(yarnMasterDTO.getUnitSno());
        yarnMaster.setTypes(yarnMasterDTO.getTypes());
        yarnMaster.setConversion(yarnMasterDTO.getConversion());
        yarnMaster.setContent(yarnMasterDTO.getContent());
        yarnMaster.setActiveFlag(yarnMasterDTO.getActiveFlag());

        YarnMaster savedYarnMaster = yarnMasterRepository.save(yarnMaster);
        return new YarnMasterDTO(savedYarnMaster);
    }

    // Get YarnMaster by ID
    public YarnMasterDTO getYarnMasterById(Long id) {
        YarnMaster yarnMaster = yarnMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("YarnMaster not found with ID: " + id));
        return new YarnMasterDTO(yarnMaster);
    }

    // Get all YarnMasters
    public List<YarnMasterDTO> getAllYarnMasters() {
        return yarnMasterRepository.findAll()
                .stream()
                .map(YarnMasterDTO::new)
                .collect(Collectors.toList());
    }

    // Update YarnMaster by ID
    public YarnMasterDTO updateYarnMaster(Long id, YarnMasterDTO yarnMasterDTO) {
        YarnMaster yarnMaster = yarnMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("YarnMaster not found with ID: " + id));

        yarnMaster.setYarnName(yarnMasterDTO.getYarnName());
        yarnMaster.setCountSno(yarnMasterDTO.getCountSno());
        yarnMaster.setUnitSno(yarnMasterDTO.getUnitSno());
        yarnMaster.setTypes(yarnMasterDTO.getTypes());
        yarnMaster.setConversion(yarnMasterDTO.getConversion());
        yarnMaster.setContent(yarnMasterDTO.getContent());
        yarnMaster.setActiveFlag(yarnMasterDTO.getActiveFlag());

        YarnMaster updatedYarnMaster = yarnMasterRepository.save(yarnMaster);
        return new YarnMasterDTO(updatedYarnMaster);
    }

    // Delete YarnMaster by ID
//    public void deleteYarnMaster(Long id) {
//        if (!yarnMasterRepository.existsById(id)) {
//            throw new IllegalArgumentException("YarnMaster not found with ID: " + id);
//        }
//        yarnMasterRepository.deleteById(id);
//    }
    public void deleteYarnMaster(Long id) {
        // Check if category exists first
        if (!yarnMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("Yarn not found with id: " + id);
        }
        
        try {
        	yarnMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Yarn because it is referenced by other");
        }
    }
    
}
