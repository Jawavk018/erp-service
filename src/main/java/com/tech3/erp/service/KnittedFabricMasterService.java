package com.tech3.erp.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.KnittedFabricMasterDTO;
import com.tech3.erp.entity.KnittedFabricMaster;
import com.tech3.erp.repository.KnittedFabricMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KnittedFabricMasterService {

    private final KnittedFabricMasterRepository knittedFabricMasterRepository;

    public KnittedFabricMasterService(KnittedFabricMasterRepository knittedFabricMasterRepository) {
        this.knittedFabricMasterRepository = knittedFabricMasterRepository;
    }

    @Transactional
    public KnittedFabricMasterDTO createFabricMaster(KnittedFabricMasterDTO dto) {
        KnittedFabricMaster entity = new KnittedFabricMaster();
        mapDtoToEntity(dto, entity);
        KnittedFabricMaster saved = knittedFabricMasterRepository.save(entity);

        // Ensure ID is generated and flushed to DB
        knittedFabricMasterRepository.flush();

        return new KnittedFabricMasterDTO(saved);
    }

    public KnittedFabricMasterDTO getFabricMasterById(Long id) {
    	KnittedFabricMaster entity = knittedFabricMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FabricMaster not found with ID: " + id));
        return new KnittedFabricMasterDTO(entity);
    }

    public List<KnittedFabricMasterDTO> getAllFabricMasters() {
        return knittedFabricMasterRepository.findAll()
                .stream()
                .map(KnittedFabricMasterDTO::new)
                .collect(Collectors.toList());
    }

    public KnittedFabricMasterDTO updateFabricMaster(Long id, KnittedFabricMasterDTO dto) {
    	KnittedFabricMaster existing = knittedFabricMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FabricMaster not found with ID: " + id));
        mapDtoToEntity(dto, existing);
        KnittedFabricMaster updated = knittedFabricMasterRepository.save(existing);

        // Optional: Update warp and weft details if needed

        return new KnittedFabricMasterDTO(updated);
    }

//    public void deleteFabricMaster(Long id) {
//        if (!knittedFabricMasterRepository.existsById(id)) {
//            throw new IllegalArgumentException("FabricMaster not found with ID: " + id);
//        }
//        knittedFabricMasterRepository.deleteById(id);
//    }
    
    public void deleteFabricMaster(Long id) {
        // Check if category exists first
        if (!knittedFabricMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("FabricMaster not found with id: " + id);
        }
        
        try {
        	knittedFabricMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete FabricMaster because it is referenced by other");
        }
    }

    private void mapDtoToEntity(KnittedFabricMasterDTO dto, KnittedFabricMaster entity) {
        entity.setFabricType(dto.getFabricType());
        entity.setFabricCategoryId(dto.getFabricCategoryId());
        entity.setKnittedFabricId(dto.getKnittedFabricId());
        entity.setFabricCode(dto.getFabricCode());
        entity.setFabricName(dto.getFabricName());
        entity.setGsm(dto.getGsm());
        entity.setWidth(dto.getWidth());
        entity.setComposition(dto.getComposition());
        entity.setShrinkage(dto.getShrinkage ());
        entity.setRemarks(dto.getRemarks());
    }  

}

