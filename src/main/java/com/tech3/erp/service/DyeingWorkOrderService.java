package com.tech3.erp.service;

import com.tech3.erp.dto.DyeingWorkOrderDTO;
import com.tech3.erp.dto.DyeingWorkOrderItemDTO;
import com.tech3.erp.entity.DyeingWorkOrder;
import com.tech3.erp.entity.DyeingWorkOrderItem;
import com.tech3.erp.repository.DyeingWorkOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DyeingWorkOrderService {

    private final DyeingWorkOrderRepository dyeingWorkOrderRepository;

    public DyeingWorkOrderService(DyeingWorkOrderRepository dyeingWorkOrderRepository) {
        this.dyeingWorkOrderRepository = dyeingWorkOrderRepository;
    }

    @Transactional
    public DyeingWorkOrderDTO createDyeingWorkOrder(DyeingWorkOrderDTO dto) {
        DyeingWorkOrder entity = new DyeingWorkOrder();
        mapDtoToEntity(dto, entity);

        // Map and attach items if present
        if (dto.getItems() != null && !dto.getItems().isEmpty()) {
            List<DyeingWorkOrderItem> items = dto.getItems().stream().map(i -> {
                DyeingWorkOrderItem item = new DyeingWorkOrderItem();
                mapItemDtoToEntity(i, item);
                item.setDyeingWorkOrder(entity);
                return item;
            }).collect(Collectors.toList());
            entity.setItems(items);
        }

        // Save work order to get ID
        DyeingWorkOrder saved = dyeingWorkOrderRepository.save(entity);

        // Generate and set the work order number
        String workOrderNo = generateWorkOrderNo(saved.getId());
        saved.setDyeingWorkOrderNo(workOrderNo);
        saved = dyeingWorkOrderRepository.save(saved);

        return new DyeingWorkOrderDTO(saved);
    }

    public List<DyeingWorkOrderDTO> getAllDyeingWorkOrders() {
        return dyeingWorkOrderRepository.findAll().stream()
                .map(DyeingWorkOrderDTO::new)
                .collect(Collectors.toList());
    }

    public DyeingWorkOrderDTO getDyeingWorkOrderById(Long id) {
        Optional<DyeingWorkOrder> op = dyeingWorkOrderRepository.findById(id);
        return op.map(DyeingWorkOrderDTO::new).orElse(null);
    }

    @Transactional
    public DyeingWorkOrderDTO updateDyeingWorkOrder(Long id, DyeingWorkOrderDTO dto) {
        DyeingWorkOrder entity = dyeingWorkOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DyeingWorkOrder not found with id: " + id));
        mapDtoToEntity(dto, entity);

        // Remove existing items and set new ones
        entity.getItems().clear();
        if (dto.getItems() != null && !dto.getItems().isEmpty()) {
            List<DyeingWorkOrderItem> items = dto.getItems().stream().map(i -> {
                DyeingWorkOrderItem item = new DyeingWorkOrderItem();
                mapItemDtoToEntity(i, item);
                item.setDyeingWorkOrder(entity);
                return item;
            }).collect(Collectors.toList());
            entity.getItems().addAll(items);
        }

        DyeingWorkOrder saved = dyeingWorkOrderRepository.save(entity);
        return new DyeingWorkOrderDTO(saved);
    }

    @Transactional
    public boolean deleteDyeingWorkOrder(Long id) {
        Optional<DyeingWorkOrder> op = dyeingWorkOrderRepository.findById(id);
        if (op.isPresent()) {
            dyeingWorkOrderRepository.delete(op.get());
            return true;
        }
        return false;
    }

    private void mapDtoToEntity(DyeingWorkOrderDTO dto, DyeingWorkOrder entity) {
        entity.setProcessContactDate(dto.getProcessContactDate());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setVendorId(dto.getVendorId());
        entity.setSalesOrderNo(dto.getSalesOrderNo());
        entity.setConsigneeId(dto.getConsigneeId());
        entity.setLapDipStatusId(dto.getLapDipStatusId());
        entity.setFirstYardageId(dto.getFirstYardageId());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setRemarks(dto.getRemarks());
        entity.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true); // default true
    }

    private void mapItemDtoToEntity(DyeingWorkOrderItemDTO dto, DyeingWorkOrderItem entity) {
        entity.setFinishedFabricCodeId(dto.getFinishedFabricCodeId());
        entity.setFinishedFabricName(dto.getFinishedFabricName());
        entity.setGreigeFabricCodeId(dto.getGreigeFabricCodeId());
        entity.setGreigeFabricName(dto.getGreigeFabricName());
        entity.setQuantity(dto.getQuantity());
        entity.setCostPerPound(dto.getCostPerPound());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setColorId(dto.getColorId());
        entity.setPantone(dto.getPantone());
        entity.setFinishedWeight(dto.getFinishedWeight());
        entity.setGreigeWidth(dto.getGreigeWidth());
        entity.setReqFinishedWidth(dto.getReqFinishedWidth());
        entity.setUomId(dto.getUomId());
        entity.setRemarks(dto.getRemarks());
        entity.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true); // default true
    }

    private String generateWorkOrderNo(Long id) {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return "DWO-" + dateStr + "-" + String.format("%05d", id);
    }
}
