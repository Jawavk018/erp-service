package com.tech3.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.LotEntryDTO;
import com.tech3.erp.entity.LotEntry;
import com.tech3.erp.repository.LotEntryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotEntryService {

    @Autowired
    private LotEntryRepository lotEntryRepository;

    public List<LotEntryDTO> getAllLotEntries() {
        List<LotEntry> lotEntries = lotEntryRepository.findAll();
        return lotEntries.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private LotEntryDTO convertToDTO(LotEntry lotEntry) {
        LotEntryDTO dto = new LotEntryDTO();
        dto.setId(lotEntry.getId());
//        dto.getPurchaseInwardItem(lotEntry.getPurchaseInwardItem());
        dto.setLotNumber(lotEntry.getLotNumber());
        dto.setQuantity(lotEntry.getQuantity());
        dto.setRejectedQuantity(lotEntry.getRejectedQuantity());
        dto.setCost(lotEntry.getCost());
        dto.setRemarks(lotEntry.getRemarks());
//        dto.setActiveFlag(lotEntry.isActiveFlag());
        return dto;
    }
}