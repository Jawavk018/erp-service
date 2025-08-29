package com.tech3.erp.service;

import com.tech3.erp.dto.PurchaseInwardDTO;
import com.tech3.erp.entity.PurchaseInward;
import com.tech3.erp.entity.PurchaseInwardItem;
import com.tech3.erp.entity.LotEntry;
import com.tech3.erp.repository.PurchaseInwardRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseInwardService {

    @Autowired
    private PurchaseInwardRepository inwardRepository;

    @Transactional
    public PurchaseInward createPurchaseInward(PurchaseInwardDTO dto) {
        PurchaseInward inward = new PurchaseInward();
        inward.setPurchaseOrderId(dto.getPurchaseOrderId());
//        inward.setPurchaseOrderNo(dto.getPurchaseOrderNo());
        inward.setRemarks(dto.getRemarks());
        inward.setInwardDate(LocalDateTime.now());
        inward.setActiveFlag(true);

        List<PurchaseInwardItem> inwardItems = dto.getPurchaseInwardItemsDtl().stream().map(itemDto -> {
            PurchaseInwardItem item = new PurchaseInwardItem();
            item.setPurchaseOrderItemId(itemDto.getPoItemId());
            item.setQuantityReceived(itemDto.getQuantityReceived());
            item.setPrice(itemDto.getPrice());
            item.setPurchaseInward(inward);
            item.setActiveFlag(true);

            List<LotEntry> lotEntries = itemDto.getLotEntries().stream().map(lotDto -> {
                LotEntry lot = new LotEntry();
                lot.setLotNumber(lotDto.getLotNumber());
                lot.setWarehouseId(lotDto.getWarehouseId());
                lot.setQuantity(lotDto.getQuantity()); // ✅ received quantity
                lot.setRejectedQuantity(lotDto.getRejectedQuantity()); // ✅ rejected quantity
                lot.setCost(lotDto.getCost());
                lot.setRemarks(lotDto.getRemarks());
                lot.setPurchaseInwardItem(item);
                lot.setActiveFlag(true);
                return lot;
            }).collect(Collectors.toList());

            item.setLotEntries(lotEntries);
            return item;
        }).collect(Collectors.toList());

        inward.setItems(inwardItems);
        return inwardRepository.save(inward);
    }

    // Get all Purchase Inward records
    public List<PurchaseInward> getAllPurchaseInwards() {
        return inwardRepository.findAll();
    }

    // Get a Purchase Inward by ID
    public PurchaseInward getPurchaseInwardById(Long id) {
        Optional<PurchaseInward> inward = inwardRepository.findById(id);
        return inward.orElse(null);
    }

    // Delete a Purchase Inward by ID (Soft Delete or Physical Delete)
//    public boolean deletePurchaseInward(Long id) {
//        Optional<PurchaseInward> inwardOpt = inwardRepository.findById(id);
//        if (inwardOpt.isPresent()) {
//            PurchaseInward inward = inwardOpt.get();
//            inwardRepository.delete(inward); // you can change to soft-delete if needed
//            return true;
//        } else {
//            return false;
//        }
//    }
    public void deletePurchaseInward(Long id) {
        // Check if category exists first
        if (!inwardRepository.existsById(id)) {
            throw new EntityNotFoundException("Purchase Inward not found with id: " + id);
        }   
        try {
        	inwardRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Purchase Inward because it is referenced by other");
        }
    }
}

