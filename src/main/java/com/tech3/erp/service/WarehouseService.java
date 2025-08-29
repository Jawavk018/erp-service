package com.tech3.erp.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.WarehouseDTO;
import com.tech3.erp.entity.Warehouse;
import com.tech3.erp.repository.WarehouseRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO) {
    	Warehouse warehouse = new Warehouse();
    	warehouse.setWarehouseName(warehouseDTO.getWarehouseName());

        return new WarehouseDTO(warehouseRepository.save(warehouse));
    }

    public WarehouseDTO getWarehouseById(Long id) {
    	Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Warehouse not found"));
        return new WarehouseDTO(warehouse);
    }

    public List<WarehouseDTO> getAllWarehouse() {
        return warehouseRepository.findAll()
                .stream()
                .map(WarehouseDTO::new)
                .collect(Collectors.toList());
    }

    public WarehouseDTO updateWarehouse(Long id, WarehouseDTO warehouseDTO) {
    	Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flang not found"));

    	warehouse.setWarehouseName(warehouseDTO.getWarehouseName());
    	warehouse.setActiveFlag(warehouseDTO.getActiveFlag());

        return new WarehouseDTO(warehouseRepository.save(warehouse));
    }
        
    public void deleteWarehouse(Long id) {
        // Check if category exists first
        if (!warehouseRepository.existsById(id)) {
            throw new EntityNotFoundException("Warehouse not found with id: " + id);
        }
        
        try {
        	warehouseRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Warehouse because it is referenced by other");
        }
    }
    

}
