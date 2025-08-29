package com.tech3.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.FinishFabricReceiveDTO;
import com.tech3.erp.dto.FinishFabricReceiveItemDTO;
import com.tech3.erp.entity.FinishFabricReceive;
import com.tech3.erp.entity.FinishFabricReceiveItem;
import com.tech3.erp.repository.FinishFabricReceiveItemRepository;
import com.tech3.erp.repository.FinishFabricReceiveRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinishFabricReceiveService {

    private final FinishFabricReceiveRepository receiveRepository;
    private final FinishFabricReceiveItemRepository itemRepository;

    @Autowired
    public FinishFabricReceiveService(FinishFabricReceiveRepository receiveRepository,
                                     FinishFabricReceiveItemRepository itemRepository) {
        this.receiveRepository = receiveRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public FinishFabricReceive createFinishFabricReceive(FinishFabricReceiveDTO dto) {
        validateFinishFabricReceiveDTO(dto);
        
        FinishFabricReceive receive = mapDtoToEntity(dto);
        
        List<FinishFabricReceiveItem> items = dto.getItems().stream()
            .map(itemDTO -> mapItemDtoToEntity(itemDTO, receive))
            .collect(Collectors.toList());

        receive.setItems(items);
        return receiveRepository.save(receive);
    }

    public List<FinishFabricReceive> getAllFinishFabricReceives() {
        return receiveRepository.findAll();
    }

    public FinishFabricReceive getFinishFabricReceiveById(Long id) {
        return receiveRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Finish Fabric Receive not found with id: " + id));
    }

    @Transactional
    public FinishFabricReceive updateFinishFabricReceive(Long id, FinishFabricReceiveDTO dto) {
        validateFinishFabricReceiveDTO(dto);
        
        FinishFabricReceive receive = receiveRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Finish Fabric Receive not found with id: " + id));
        
        mapDtoToEntity(dto, receive);

        // First remove existing items
        itemRepository.deleteByFinishFabricReceiveId(id);
        
        // Then add new items
        List<FinishFabricReceiveItem> items = dto.getItems().stream()
            .map(itemDTO -> mapItemDtoToEntity(itemDTO, receive))
            .collect(Collectors.toList());
        
        receive.setItems(items);
        return receiveRepository.save(receive);
    }

    @Transactional
    public void deleteFinishFabricReceive(Long id) {
        FinishFabricReceive receive = receiveRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Finish Fabric Receive not found with id: " + id));
        
        try {
            // First delete items
            itemRepository.deleteByFinishFabricReceiveId(id);
            // Then delete the receive record
            receiveRepository.delete(receive);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Finish Fabric Receive because it is referenced by other entities", e);
        }
    }

    // Helper methods
    private void validateFinishFabricReceiveDTO(FinishFabricReceiveDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("FinishFabricReceiveDTO cannot be null");
        }
        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new IllegalArgumentException("At least one item is required");
        }
        // Add more validation as needed
    }

    private FinishFabricReceive mapDtoToEntity(FinishFabricReceiveDTO dto) {
        FinishFabricReceive receive = new FinishFabricReceive();
        mapDtoToEntity(dto, receive);
        return receive;
    }

    private void mapDtoToEntity(FinishFabricReceiveDTO dto, FinishFabricReceive receive) {
        receive.setFabricReceiveDate(dto.getFabricReceiveDate());
        receive.setVendorId(dto.getVendorId());
        receive.setDyeingWorkOrderId(dto.getDyeingWorkOrderId());
        receive.setOrderQuantity(dto.getOrderQuantity());
        receive.setCostPerPound(dto.getCostPerPound());
        receive.setTotalAmount(dto.getTotalAmount());
        receive.setColorId(dto.getColorId());
        receive.setPantone(dto.getPantone());
        receive.setFinishingId(dto.getFinishingId());
        receive.setSalesOrderId(dto.getSalesOrderId());
        receive.setPurchaseInwardId(dto.getPurchaseInwardId());
        receive.setDispatchedQuantity(dto.getDispatchedQuantity());
        receive.setReceivedQuantity(dto.getReceivedQuantity());
        receive.setBalanceQuantity(dto.getBalanceQuantity());
        receive.setRemarks(dto.getRemarks());
        receive.setActiveFlag(dto.getActiveFlag());
    }

    private FinishFabricReceiveItem mapItemDtoToEntity(FinishFabricReceiveItemDTO itemDTO, FinishFabricReceive receive) {
        FinishFabricReceiveItem item = new FinishFabricReceiveItem();
        item.setFinishedFabricCode(itemDTO.getFinishedFabricCode());
        item.setRollNo(itemDTO.getRollNo());
        item.setRollYards(itemDTO.getRollYards());
        item.setWeight(itemDTO.getWeight());
        item.setGradeId(itemDTO.getGradeId());
        item.setWarehouseId(itemDTO.getWarehouseId());
        item.setActiveFlag(itemDTO.getActiveFlag());
        item.setFinishFabricReceive(receive);
        return item;
    }
}