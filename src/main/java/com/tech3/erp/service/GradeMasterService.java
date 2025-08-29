package com.tech3.erp.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.GradeMasterDTO;
import com.tech3.erp.entity.GradeMaster;
import com.tech3.erp.repository.GradeMasterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeMasterService {

    private final GradeMasterRepository gradeMasterRepository;

    @Autowired
    public GradeMasterService(GradeMasterRepository gradeMasterRepository) {
        this.gradeMasterRepository = gradeMasterRepository;
    }

    @Transactional
    public GradeMasterDTO createGradeMaster(GradeMasterDTO dto) {
        GradeMaster gradeMaster = new GradeMaster();
        mapDtoToEntity(dto, gradeMaster);
        gradeMaster = gradeMasterRepository.save(gradeMaster);
        return mapEntityToDto(gradeMaster);
    }

    public List<GradeMasterDTO> getAllGradeMasters() {
        return gradeMasterRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public GradeMasterDTO getGradeMasterById(Long id) {
        GradeMaster gradeMaster = gradeMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade Master not found with id: " + id));
        return mapEntityToDto(gradeMaster);
    }

    @Transactional
    public GradeMasterDTO updateGradeMaster(Long id, GradeMasterDTO dto) {
        GradeMaster gradeMaster = gradeMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade Master not found with id: " + id));

        mapDtoToEntity(dto, gradeMaster);
        gradeMaster = gradeMasterRepository.save(gradeMaster);
        return mapEntityToDto(gradeMaster);
    }

//    @Transactional
//    public void deleteGradeMaster(Long id) {
//        if (!gradeMasterRepository.existsById(id)) {
//            throw new EntityNotFoundException("Grade Master not found with id: " + id);
//        }
//        gradeMasterRepository.deleteById(id);
//    }
    public void deleteGradeMaster(Long id) {
        // Check if category exists first
        if (!gradeMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("Grade not found with id: " + id);
        }
        
        try {
        	gradeMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Grade because it is referenced by other");
        }
    }

    private GradeMasterDTO mapEntityToDto(GradeMaster entity) {
        GradeMasterDTO dto = new GradeMasterDTO();
        dto.setId(entity.getId());
        dto.setGradeCode(entity.getGradeCode());
        dto.setGradeName(entity.getGradeName());
        dto.setMinPoint(entity.getMinPoint());
        dto.setMaxPoint(entity.getMaxPoint());
        dto.setDescription(entity.getDescription());
        dto.setActiveFlag(entity.getActiveFlag());
        return dto;
    }

    private void mapDtoToEntity(GradeMasterDTO dto, GradeMaster entity) {
        entity.setGradeCode(dto.getGradeCode());
        entity.setGradeName(dto.getGradeName());
        entity.setMinPoint(dto.getMinPoint());
        entity.setMaxPoint(dto.getMaxPoint());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
    }
}
