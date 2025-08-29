package com.tech3.erp.service;

import com.tech3.erp.dto.PurchaseOrderDTO;
import com.tech3.erp.dto.PurchaseOrderItemDTO;
import com.tech3.erp.dto.VendorDTO;
import com.tech3.erp.entity.PurchaseOrder;
import com.tech3.erp.entity.PurchaseOrderItem;
import com.tech3.erp.repository.PurchaseOrderRepository;
import com.tech3.erp.repository.VendorRepository;

import jakarta.persistence.EntityNotFoundException;

import com.tech3.erp.repository.PurchaseOrderItemRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderItemRepository purchaseOrderItemRepository;
    private final VendorRepository vendorRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository,
                                PurchaseOrderItemRepository purchaseOrderItemRepository, VendorRepository vendorRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
        this.vendorRepository = vendorRepository;
    }
    
    @Transactional
    public PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO dto) {
        PurchaseOrder entity = new PurchaseOrder();
        mapDtoToEntity(dto, entity);

        // Set items properly
        if (dto.getPurchaseOrderItemsDtl() != null && !dto.getPurchaseOrderItemsDtl().isEmpty()) {
            List<PurchaseOrderItem> items = dto.getPurchaseOrderItemsDtl().stream().map(i -> {
                PurchaseOrderItem item = new PurchaseOrderItem(i);
                item.setPurchaseOrder(entity); // 🔥 Crucial: set back-reference
                return item;
            }).collect(Collectors.toList());

            entity.setItems(items); // 🔥 Crucial: attach to parent
        }

        // Only save parent entity
        PurchaseOrder saved = purchaseOrderRepository.save(entity); // cascade saves items too
        return new PurchaseOrderDTO(saved);
    }

    public PurchaseOrderDTO getPurchaseOrderById(Long id) {
        PurchaseOrder entity = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseOrder not found with ID: " + id));
        return new PurchaseOrderDTO(entity);
    }

    public List<PurchaseOrderDTO> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll()
                .stream()
                .map(PurchaseOrderDTO::new)
                .collect(Collectors.toList());
    }

    public PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO dto) {
        PurchaseOrder existing = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseOrder not found with ID: " + id));
        mapDtoToEntity(dto, existing);
        PurchaseOrder updated = purchaseOrderRepository.save(existing);
        
        // Optional: update order items if required
        return new PurchaseOrderDTO(updated);
    }

//    public void deletePurchaseOrder(Long id) {
//        if (!purchaseOrderRepository.existsById(id)) {
//            throw new IllegalArgumentException("PurchaseOrder not found with ID: " + id);
//        }
//        purchaseOrderRepository.deleteById(id);
//    }
    public void deletePurchaseOrder(Long id) {
        // Check if category exists first
        if (!purchaseOrderRepository.existsById(id)) {
            throw new EntityNotFoundException("Purchase Order not found with id: " + id);
        }   
        try {
        	purchaseOrderRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Purchase Order because it is referenced by other");
        }
    }

    public List<PurchaseOrderDTO> getPurchaseOrdersByVendorId(Long vendorId) {
        List<PurchaseOrder> orders = purchaseOrderRepository.findByVendorId(vendorId);
        if (orders.isEmpty()) {
            throw new IllegalArgumentException("No purchase orders found for Vendor ID: " + vendorId);
        }
        return orders.stream().map(PurchaseOrderDTO::new).toList();
    }

    
    private void mapDtoToEntity(PurchaseOrderDTO dto, PurchaseOrder entity) {
        entity.setPoTypeId(dto.getPoTypeId());
        entity.setPoNo(dto.getPoNo());
        entity.setPoDate(dto.getPoDate());
        entity.setVendorId(dto.getVendorId());
        entity.setTaxId(dto.getTaxId());
        entity.setActiveFlag(dto.getActiveFlag());
    }
    
 // Add this new method
    public List<VendorDTO> getVendorsByPoType(Long poTypeId) {
        List<Long> vendorIds = purchaseOrderRepository.findVendorIdsByPoTypeId(poTypeId);
        if (vendorIds.isEmpty()) {
            throw new IllegalArgumentException("No vendors found for PO Type ID: " + poTypeId);
        }
        return vendorRepository.findAllById(vendorIds)
                .stream()
                .map(VendorDTO::new)
                .collect(Collectors.toList());
    }
    
}
