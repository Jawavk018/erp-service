package com.tech3.erp.service;

import com.tech3.erp.dto.ShipmentModeDTO;
import com.tech3.erp.entity.ShipmentMode;
import com.tech3.erp.repository.ShipmentModeRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentModeService {

    private final ShipmentModeRepository shipmentModeRepository;

    public ShipmentModeService(ShipmentModeRepository shipmentModeRepository) {
        this.shipmentModeRepository = shipmentModeRepository;
    }

    public ShipmentModeDTO createShipmentMode(ShipmentModeDTO shipmentModeDTO) {
        ShipmentMode shipmentMode = new ShipmentMode();
        shipmentMode.setModeName(shipmentModeDTO.getModeName());
        shipmentMode.setDescription(shipmentModeDTO.getDescription());
        shipmentMode.setActiveFlag(shipmentModeDTO.getActiveFlag());
        
        return new ShipmentModeDTO(shipmentModeRepository.save(shipmentMode));
    }


    public ShipmentModeDTO getShipmentModeById(Long id) {
        return shipmentModeRepository.findById(id)
                .map(ShipmentModeDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Shipment mode not found"));
    }

    public List<ShipmentModeDTO> getAllShipmentModes() {
        return shipmentModeRepository.findAll().stream().map(ShipmentModeDTO::new).collect(Collectors.toList());
    }

    public ShipmentModeDTO updateShipmentMode(Long id, ShipmentModeDTO shipmentModeDTO) {
        ShipmentMode shipmentMode = shipmentModeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment mode not found"));
        shipmentMode.setModeName(shipmentModeDTO.getModeName());
        shipmentMode.setDescription(shipmentModeDTO.getDescription());
        shipmentMode.setActiveFlag(shipmentModeDTO.getActiveFlag());
        return new ShipmentModeDTO(shipmentModeRepository.save(shipmentMode));
    }

//    public void deleteShipmentMode(Long id) {
//        if (!shipmentModeRepository.existsById(id)) {
//            throw new IllegalArgumentException("Shipment mode not found");
//        }
//        shipmentModeRepository.deleteById(id);
//    }
    
	public void deleteShipmentMode(Long id) {
	        // Check if category exists first
	        if (!shipmentModeRepository.existsById(id)) {
	            throw new EntityNotFoundException("ShipmentMode not found with id: " + id);
	        }
	        
	        try {
	        	shipmentModeRepository.deleteById(id);
	        } catch (DataIntegrityViolationException e) {
	            throw new IllegalStateException("Cannot delete ShipmentMode because it is referenced by other");
	        }
	    }

}
