package com.tech3.erp.service;

import com.tech3.erp.dto.TermsConditionsDTO;
import com.tech3.erp.entity.TermsConditions;
import com.tech3.erp.repository.TermsConditionsRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermsConditionsService {

    private final TermsConditionsRepository repository;

    public TermsConditionsService(TermsConditionsRepository repository) {
        this.repository = repository;
    }

    public TermsConditionsDTO createTermsCondition(TermsConditionsDTO dto) {
        TermsConditions entity = new TermsConditions();
        entity.setTermsConditionsName(dto.getTermsConditionsName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new TermsConditionsDTO(repository.save(entity));
    }

    public TermsConditionsDTO getTermsConditionById(Long id) {
        return repository.findById(id)
                .map(TermsConditionsDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Terms & Conditions not found"));
    }

    public List<TermsConditionsDTO> getAllTermsConditions() {
        return repository.findAll().stream().map(TermsConditionsDTO::new).collect(Collectors.toList());
    }

    public TermsConditionsDTO updateTermsCondition(Long id, TermsConditionsDTO dto) {
        TermsConditions entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Terms & Conditions not found"));
        entity.setTermsConditionsName(dto.getTermsConditionsName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new TermsConditionsDTO(repository.save(entity));
    }

//    public void deleteTermsCondition(Long id) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("Terms & Conditions not found");
//        }
//        repository.deleteById(id);
//    }
    public void deleteTermsCondition(Long id) {
        // Check if category exists first
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Terms & Conditions not found with id: " + id);
        }
        
        try {
        	repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Terms & Conditions because it is referenced by other");
        }
    }
    
}

