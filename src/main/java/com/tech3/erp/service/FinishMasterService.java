package com.tech3.erp.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.FinishMasterDTO;
import com.tech3.erp.entity.FinishMaster;
import com.tech3.erp.repository.FinishMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinishMasterService {

    private final FinishMasterRepository repository;

    public FinishMasterService(FinishMasterRepository repository) {
        this.repository = repository;
    }

    public FinishMasterDTO createFinishMaster(FinishMasterDTO dto) {
        FinishMaster entity = new FinishMaster();
        entity.setFinishName(dto.getFinishName());
        entity.setFinishCode(dto.getFinishCode());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new FinishMasterDTO(repository.save(entity));
    }

    public FinishMasterDTO getFinishMasterById(Long id) {
        return repository.findById(id)
                .map(FinishMasterDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("FinishMaster not found"));
    }

    public List<FinishMasterDTO> getAllFinishMaster() {
        return repository.findAll().stream().map(FinishMasterDTO::new).collect(Collectors.toList());
    }

    public FinishMasterDTO updateFinishMaster(Long id, FinishMasterDTO dto) {
    	FinishMaster entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FinishMaster not found"));
        entity.setFinishName(dto.getFinishName());
        entity.setFinishCode(dto.getFinishCode());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new FinishMasterDTO(repository.save(entity));
    }

//    public void deleteFinishMaster(Long id) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("FinishMaster not found");
//        }
//        repository.deleteById(id);
//    }
    
    public void deleteFinishMaster(Long id) {
        // Check if category exists first
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Finish not found with id: " + id);
        }
        
        try {
        	repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Finish because it is referenced by other");
        }
    }
    
}
