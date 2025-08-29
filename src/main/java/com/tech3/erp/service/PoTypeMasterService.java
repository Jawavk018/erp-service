package com.tech3.erp.service;

import com.tech3.erp.dto.PoTypeMasterDTO;
import com.tech3.erp.entity.PoTypeMaster;
import com.tech3.erp.repository.PoTypeMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoTypeMasterService {

    private final PoTypeMasterRepository poTypeMasterRepository;

    public PoTypeMasterService(PoTypeMasterRepository poTypeMasterRepository) {
        this.poTypeMasterRepository = poTypeMasterRepository;
    }

    // Create new PO Type
    public PoTypeMasterDTO createPoType(PoTypeMasterDTO dto) {
        PoTypeMaster entity = new PoTypeMaster();
        entity.setPoTypeName(dto.getPoTypeName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());

        return new PoTypeMasterDTO(poTypeMasterRepository.save(entity));

    }

    // Get PO Type by ID
    public PoTypeMasterDTO getPoTypeById(Long id) {
        return poTypeMasterRepository.findById(id)
                .map(PoTypeMasterDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("PO Type not found with ID: " + id));
    }

    // Get all PO Types
    public List<PoTypeMasterDTO> getAllPoTypes() {
        return poTypeMasterRepository.findAll()
                .stream()
                .map(PoTypeMasterDTO::new)
                .collect(Collectors.toList());
    }

    // Update PO Type
    public PoTypeMasterDTO updatePoType(Long id, PoTypeMasterDTO dto) {
        PoTypeMaster entity = poTypeMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PO Type not found with ID: " + id));

        entity.setPoTypeName(dto.getPoTypeName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());

        return new PoTypeMasterDTO(poTypeMasterRepository.save(entity));
    }

    // Delete PO Type
//    public void deletePoType(Long id) {
//        if (!poTypeMasterRepository.existsById(id)) {
//            throw new IllegalArgumentException("PO Type not found with ID: " + id);
//        }
//        poTypeMasterRepository.deleteById(id);
//    }
    public void deletePoType(Long id) {
        // Check if category exists first
        if (!poTypeMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("PO Type not found with id: " + id);
        }
        
        try {
        	poTypeMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete PO Type because it is referenced by other");
        }
    }
}
