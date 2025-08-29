package com.tech3.erp.service;

import com.tech3.erp.dto.GeneratePackingDTO;
import com.tech3.erp.dto.GeneratePackingItemDTO;
import com.tech3.erp.entity.GeneratePacking;
import com.tech3.erp.entity.GeneratePackingItem;
import com.tech3.erp.repository.GeneratePackingItemRepository;
import com.tech3.erp.repository.GeneratePackingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneratePackingService {

    private final GeneratePackingRepository packingRepository;
    private final GeneratePackingItemRepository itemRepository;

    @Autowired
    public GeneratePackingService(GeneratePackingRepository packingRepository, 
                                GeneratePackingItemRepository itemRepository) {
        this.packingRepository = packingRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public GeneratePackingDTO createGeneratePacking(GeneratePackingDTO dto) {
        // Create and save the main packing entity
        GeneratePacking packing = new GeneratePacking();
        packing.setPackingDate(dto.getPackingDate());
        packing.setBuyerId(dto.getBuyerId());
        packing.setSalesOrderId(dto.getSalesOrderId());
        packing.setWarehouseId(dto.getWarehouseId());
        packing.setTareWeight(dto.getTareWeight());
        packing.setGrossWeight(dto.getGrossWeight());
        packing.setPackingSlipNo(dto.getPackingSlipNo());

        GeneratePacking savedPacking = packingRepository.save(packing);

        // Save packing items if they exist
        if (dto.getItems() != null && !dto.getItems().isEmpty()) {
            List<GeneratePackingItem> items = dto.getItems().stream()
                .map(itemDto -> {
                    GeneratePackingItem item = new GeneratePackingItem();
                    item.setGeneratePacking(savedPacking);
                    item.setRollNo(itemDto.getRollNo());
                    item.setLength(itemDto.getLength());
                    item.setUomId(itemDto.getUomId());
                    item.setPounds(itemDto.getPounds());
                    item.setLotId(itemDto.getLotId());
                    return item;
                })
                .collect(Collectors.toList());
            
            itemRepository.saveAll(items);
            savedPacking.setItems(items);
        }

        return convertToDTO(savedPacking);
    }

    public GeneratePackingDTO getGeneratePackingById(Long id) {
        GeneratePacking packing = packingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Generate Packing not found with id: " + id));
        return convertToDTO(packing);
    }

    @Transactional
    public GeneratePackingDTO updateGeneratePacking(Long id, GeneratePackingDTO dto) {
        GeneratePacking packing = packingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Generate Packing not found with id: " + id));

        // Update packing details
        packing.setPackingDate(dto.getPackingDate());
        packing.setBuyerId(dto.getBuyerId());
        packing.setSalesOrderId(dto.getSalesOrderId());
        packing.setWarehouseId(dto.getWarehouseId());
        packing.setTareWeight(dto.getTareWeight());
        packing.setGrossWeight(dto.getGrossWeight());
        packing.setPackingSlipNo(dto.getPackingSlipNo());

        // Handle items update properly
        if (dto.getItems() != null) {
            // Clear existing items from the collection (this will trigger orphan removal)
            packing.getItems().clear();
            
            // Add all new items to the existing collection
            dto.getItems().forEach(itemDto -> {
                GeneratePackingItem item = new GeneratePackingItem();
                item.setGeneratePacking(packing);
                item.setRollNo(itemDto.getRollNo());
                item.setLength(itemDto.getLength());
                item.setUomId(itemDto.getUomId());
                item.setPounds(itemDto.getPounds());
                item.setLotId(itemDto.getLotId());
                packing.getItems().add(item);
            });
        } else {
            // If no items in DTO, clear all items
            packing.getItems().clear();
        }

        GeneratePacking updatedPacking = packingRepository.save(packing);
        return convertToDTO(updatedPacking);
    }

    @Transactional
    public void deleteGeneratePacking(Long id) {
        if (!packingRepository.existsById(id)) {
            throw new EntityNotFoundException("Generate Packing not found with id: " + id);
        } 
        try {
            // First delete items
            itemRepository.deleteByGeneratePackingId(id);
            // Then delete the packing
            packingRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Generate Packing because it is referenced by other");
        }
    }

    private GeneratePackingDTO convertToDTO(GeneratePacking packing) {
        GeneratePackingDTO dto = new GeneratePackingDTO();
        dto.setId(packing.getId());
        dto.setPackingDate(packing.getPackingDate());
        dto.setBuyerId(packing.getBuyerId());
        dto.setSalesOrderId(packing.getSalesOrderId());
        dto.setWarehouseId(packing.getWarehouseId());
        dto.setTareWeight(packing.getTareWeight());
        dto.setGrossWeight(packing.getGrossWeight());
        dto.setPackingSlipNo(packing.getPackingSlipNo());

        if (packing.getItems() != null) {
            List<GeneratePackingItemDTO> itemDTOs = packing.getItems().stream()
                .map(item -> new GeneratePackingItemDTO(
                    item.getId(),
                    packing.getId(),
                    item.getRollNo(),
                    item.getLength(),
                    item.getUomId(),
                    item.getPounds(),
                    item.getLotId()
                ))
                .collect(Collectors.toList());
            dto.setItems(itemDTOs);
        }

        return dto;
    }

    public List<GeneratePackingDTO> getAllGeneratePackings() {
        List<GeneratePacking> packings = packingRepository.findAll();
        
        return packings.stream()
            .map(packing -> {
                GeneratePackingDTO dto = new GeneratePackingDTO();
                dto.setId(packing.getId());
                dto.setPackingDate(packing.getPackingDate());
                dto.setBuyerId(packing.getBuyerId());
                dto.setSalesOrderId(packing.getSalesOrderId());
                dto.setWarehouseId(packing.getWarehouseId());
                dto.setTareWeight(packing.getTareWeight());
                dto.setGrossWeight(packing.getGrossWeight());
                dto.setPackingSlipNo(packing.getPackingSlipNo());
                
                // Convert items to DTOs if they exist
                if (packing.getItems() != null) {
                    List<GeneratePackingItemDTO> itemDTOs = packing.getItems().stream()
                        .map(item -> {
                            GeneratePackingItemDTO itemDto = new GeneratePackingItemDTO();
                            itemDto.setId(item.getId());
                            itemDto.setGeneratedPackingId(packing.getId());
                            itemDto.setRollNo(item.getRollNo());
                            itemDto.setLength(item.getLength());
                            itemDto.setUomId(item.getUomId());
                            itemDto.setPounds(item.getPounds());
                            itemDto.setLotId(item.getLotId());
                            return itemDto;
                        })
                        .collect(Collectors.toList());
                    dto.setItems(itemDTOs);
                }
                
                return dto;
            })
            .collect(Collectors.toList());
    }
}
