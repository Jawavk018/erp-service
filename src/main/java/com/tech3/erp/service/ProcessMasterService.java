package com.tech3.erp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.ProcessMasterDTO;
import com.tech3.erp.entity.ProcessMaster;
import com.tech3.erp.repository.ProcessMasterRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProcessMasterService {
	
	private final ProcessMasterRepository processMasterRepository;

    @Autowired
    public ProcessMasterService(ProcessMasterRepository processMasterRepository) {
        this.processMasterRepository = processMasterRepository;
    }

    @Transactional
    public ProcessMasterDTO createProcessMaster(ProcessMasterDTO dto) {
//        if (defectMasterRepository.existsByDefectCode(dto.getDefectCode())) {
//            throw new DataIntegrityViolationException("Defect code already exists");
//        }
//
//        if (defectMasterRepository.existsByDefectName(dto.getDefectName())) {
//            throw new DataIntegrityViolationException("Defect name already exists");
//        }

        ProcessMaster processMaster = new ProcessMaster();
        mapDtoToEntity(dto, processMaster);
        processMaster = processMasterRepository.save(processMaster);
        return mapEntityToDto(processMaster);
    }

    public List<ProcessMasterDTO> getAllProcessMasters() {
        return processMasterRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public ProcessMasterDTO getProcessMasterById(Long id) {
        ProcessMaster processMaster = processMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Process Master not found with id: " + id));
        return mapEntityToDto(processMaster);
    }

    @Transactional
    public ProcessMasterDTO updateProcessMaster(Long id, ProcessMasterDTO dto) {
    	ProcessMaster processMaster = processMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Process Master not found with id: " + id));

//        if (defectMasterRepository.existsByDefectCodeAndIdNot(dto.getDefectCode(), id)) {
//            throw new DataIntegrityViolationException("Defect code already exists");
//        }
//
//        if (defectMasterRepository.existsByDefectNameAndIdNot(dto.getDefectName(), id)) {
//            throw new DataIntegrityViolationException("Defect name already exists");
//        }

        mapDtoToEntity(dto, processMaster);
        processMaster = processMasterRepository.save(processMaster);
        return mapEntityToDto(processMaster);
    }

//    @Transactional
//    public void deleteDefectMaster(Long id) {
//        if (!defectMasterRepository.existsById(id)) {
//            throw new EntityNotFoundException("Defect Master not found with id: " + id);
//        }
//        defectMasterRepository.deleteById(id);
//    }

    public void deleteProcessMaster(Long id) {
        // Check if category exists first
        if (!processMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("Process not found with id: " + id);
        }
        
        try {
        	processMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Process because it is referenced by other");
        }
    }
    
    private ProcessMasterDTO mapEntityToDto(ProcessMaster entity) {
    	ProcessMasterDTO dto = new ProcessMasterDTO();
        dto.setId(entity.getId());
        dto.setProcessName(entity.getProcessName());
        dto.setDescription(entity.getDescription());
        dto.setActiveFlag(entity.getActiveFlag());
        return dto;
    }

    private void mapDtoToEntity(ProcessMasterDTO dto, ProcessMaster entity) {
        entity.setProcessName(dto.getProcessName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
    }
    

}
