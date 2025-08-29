package com.tech3.erp.service;

import com.tech3.erp.dto.ShipmentTermsDTO;
import com.tech3.erp.entity.ShipmentTerms;
import com.tech3.erp.repository.ShipmentTermsRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentTermsService {

    private final ShipmentTermsRepository repository;

    public ShipmentTermsService(ShipmentTermsRepository repository) {
        this.repository = repository;
    }

    public ShipmentTermsDTO createShipmentTerm(ShipmentTermsDTO dto) {
        ShipmentTerms entity = new ShipmentTerms();
        entity.setTermName(dto.getTermName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new ShipmentTermsDTO(repository.save(entity));
    }

    public ShipmentTermsDTO getShipmentTermById(Long id) {
        return repository.findById(id)
                .map(ShipmentTermsDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Shipment term not found"));
    }

    public List<ShipmentTermsDTO> getAllShipmentTerms() {
        return repository.findAll().stream().map(ShipmentTermsDTO::new).collect(Collectors.toList());
    }

    public ShipmentTermsDTO updateShipmentTerm(Long id, ShipmentTermsDTO dto) {
        ShipmentTerms entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment term not found"));
        entity.setTermName(dto.getTermName());
        entity.setDescription(dto.getDescription());
        entity.setActiveFlag(dto.getActiveFlag());
        return new ShipmentTermsDTO(repository.save(entity));
    }

//    public void deleteShipmentTerm(Long id) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("Shipment term not found");
//        }
//        repository.deleteById(id);
//    }
    public void deleteShipmentTerm(Long id) {
        // Check if category exists first
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Shipment term not found with id: " + id);
        }
        
        try {
        	repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Shipment term because it is referenced by other");
        }
    }
}
