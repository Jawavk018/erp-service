package com.tech3.erp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.DefectMasterDTO;
import com.tech3.erp.entity.DefectMaster;
import com.tech3.erp.repository.DefectMasterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefectMasterService {

    private final DefectMasterRepository defectMasterRepository;

    @Autowired
    public DefectMasterService(DefectMasterRepository defectMasterRepository) {
        this.defectMasterRepository = defectMasterRepository;
    }

    @Transactional
    public DefectMasterDTO createDefectMaster(DefectMasterDTO dto) {
//        if (defectMasterRepository.existsByDefectCode(dto.getDefectCode())) {
//            throw new DataIntegrityViolationException("Defect code already exists");
//        }
//
//        if (defectMasterRepository.existsByDefectName(dto.getDefectName())) {
//            throw new DataIntegrityViolationException("Defect name already exists");
//        }

        DefectMaster defectMaster = new DefectMaster();
        mapDtoToEntity(dto, defectMaster);
        defectMaster = defectMasterRepository.save(defectMaster);
        return mapEntityToDto(defectMaster);
    }

    public List<DefectMasterDTO> getAllDefectMasters() {
        return defectMasterRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public DefectMasterDTO getDefectMasterById(Long id) {
        DefectMaster defectMaster = defectMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Defect Master not found with id: " + id));
        return mapEntityToDto(defectMaster);
    }

    @Transactional
    public DefectMasterDTO updateDefectMaster(Long id, DefectMasterDTO dto) {
        DefectMaster defectMaster = defectMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Defect Master not found with id: " + id));

//        if (defectMasterRepository.existsByDefectCodeAndIdNot(dto.getDefectCode(), id)) {
//            throw new DataIntegrityViolationException("Defect code already exists");
//        }
//
//        if (defectMasterRepository.existsByDefectNameAndIdNot(dto.getDefectName(), id)) {
//            throw new DataIntegrityViolationException("Defect name already exists");
//        }

        mapDtoToEntity(dto, defectMaster);
        defectMaster = defectMasterRepository.save(defectMaster);
        return mapEntityToDto(defectMaster);
    }

//    @Transactional
//    public void deleteDefectMaster(Long id) {
//        if (!defectMasterRepository.existsById(id)) {
//            throw new EntityNotFoundException("Defect Master not found with id: " + id);
//        }
//        defectMasterRepository.deleteById(id);
//    }

    public void deleteDefectMaster(Long id) {
        // Check if category exists first
        if (!defectMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("Defect not found with id: " + id);
        }
        
        try {
        	defectMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Defect because it is referenced by other");
        }
    }
    
    private DefectMasterDTO mapEntityToDto(DefectMaster entity) {
        DefectMasterDTO dto = new DefectMasterDTO();
        dto.setId(entity.getId());
        dto.setDefectCode(entity.getDefectCode());
        dto.setDefectName(entity.getDefectName());
        dto.setDefectPoint(entity.getDefectPoint());
        dto.setDescription(entity.getDescription());
        dto.setActiveFlag(entity.getActiveFlag());
        return dto;
    }

    private void mapDtoToEntity(DefectMasterDTO dto, DefectMaster entity) {
        entity.setDefectCode(dto.getDefectCode());
        entity.setDefectName(dto.getDefectName());
        entity.setDefectPoint(dto.getDefectPoint());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
    }
}
