package com.tech3.erp.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.GstMasterDTO;
import com.tech3.erp.entity.GstMaster;
import com.tech3.erp.repository.GstMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GstMasterService {

    private final GstMasterRepository repository;

    public GstMasterService(GstMasterRepository repository) {
        this.repository = repository;
    }

    public GstMasterDTO createGstMaster(GstMasterDTO dto) {
        GstMaster entity = new GstMaster();
        entity.setGstName(dto.getGstName());
        entity.setCGstRate(dto.getCGstRate());
        entity.setSGstRate(dto.getSGstRate());
        entity.setIGstRate(dto.getIGstRate());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new GstMasterDTO(repository.save(entity));
    }

    public GstMasterDTO getGstMasterById(Long id) {
        return repository.findById(id)
                .map(GstMasterDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Gst not found"));
    }

    public List<GstMasterDTO> getAllGstMaster() {
        return repository.findAll().stream().map(GstMasterDTO::new).collect(Collectors.toList());
    }

    public GstMasterDTO updateGstMaster(Long id, GstMasterDTO dto) {
    	GstMaster entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gst not found"));
        entity.setGstName(dto.getGstName());
        entity.setCGstRate(dto.getCGstRate());
        entity.setSGstRate(dto.getSGstRate());
        entity.setIGstRate(dto.getIGstRate());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new GstMasterDTO(repository.save(entity));
    }

//    public void deleteGstMaster(Long id) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("Gst not found");
//        }
//        repository.deleteById(id);
//    }
    
    public void deleteGstMaster(Long id) {
        // Check if category exists first
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("GST not found with id: " + id);
        }
        
        try {
        	repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete GST because it is referenced by other");
        }
    }
}
