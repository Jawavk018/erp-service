package com.tech3.erp.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.UomDTO;
import com.tech3.erp.entity.Uom;
import com.tech3.erp.repository.UomRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UomService {

    private final UomRepository repository;

    public UomService(UomRepository repository) {
        this.repository = repository;
    }

    public UomDTO createUom(UomDTO dto) {
        Uom entity = new Uom();
        entity.setUomName(dto.getUomName());
        entity.setUomCode(dto.getUomCode());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new UomDTO(repository.save(entity));
    }

    public UomDTO getUomById(Long id) {
        return repository.findById(id)
                .map(UomDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Uom not found"));
    }

    public List<UomDTO> getAllUom() {
        return repository.findAll().stream().map(UomDTO::new).collect(Collectors.toList());
    }

    public UomDTO updateUom(Long id, UomDTO dto) {
    	Uom entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Uom not found"));
        entity.setUomName(dto.getUomName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new UomDTO(repository.save(entity));
    }

//    public void deleteUom(Long id) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("uom not found");
//        }
//        repository.deleteById(id);
//    }
    public void deleteUom(Long id) {
        // Check if category exists first
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Uom not found with id: " + id);
        }
        
        try {
        	repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Uom because it is referenced by other");
        }
    }
}
