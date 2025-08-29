package com.tech3.erp.service;

import com.tech3.erp.dto.WovenFabricMasterDTO;
import com.tech3.erp.dto.FabricWarpDetailDTO;
import com.tech3.erp.dto.FabricWeftDetailDTO;
import com.tech3.erp.entity.WovenFabricMaster;
import com.tech3.erp.entity.FabricWarpDetail;
import com.tech3.erp.entity.FabricWeftDetail;
import com.tech3.erp.repository.WovenFabricMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import com.tech3.erp.repository.FabricWarpDetailRepository;
import com.tech3.erp.repository.FabricWeftDetailRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WovenFabricMasterService {

    private final WovenFabricMasterRepository wovenFabricMasterRepository;
    private final FabricWarpDetailRepository warpDetailRepository;
    private final FabricWeftDetailRepository weftDetailRepository;

    public WovenFabricMasterService(WovenFabricMasterRepository wovenFabricMasterRepository,
                               FabricWarpDetailRepository warpDetailRepository,
                               FabricWeftDetailRepository weftDetailRepository) {
        this.wovenFabricMasterRepository = wovenFabricMasterRepository;
        this.warpDetailRepository = warpDetailRepository;
        this.weftDetailRepository = weftDetailRepository;
    }

    @Transactional
    public WovenFabricMasterDTO createFabricMaster(WovenFabricMasterDTO dto) {
        WovenFabricMaster entity = new WovenFabricMaster();
        mapDtoToEntity(dto, entity);
        WovenFabricMaster saved = wovenFabricMasterRepository.save(entity);

        // Ensure ID is generated and flushed to DB
        wovenFabricMasterRepository.flush();

        // Save warp details
        if (dto.getWarpDetails() != null) {
            List<FabricWarpDetail> warps = dto.getWarpDetails().stream().map(w -> {
                FabricWarpDetail detail = new FabricWarpDetail(w);
                detail.setFabricMaster(saved);
                return detail;
            }).collect(Collectors.toList());
            warpDetailRepository.saveAll(warps);
        }

        // Save weft details
        if (dto.getWeftDetails() != null) {
            List<FabricWeftDetail> wefts = dto.getWeftDetails().stream().map(w -> {
                FabricWeftDetail detail = new FabricWeftDetail(w);
                detail.setFabricMaster(saved);
                return detail;
            }).collect(Collectors.toList());
            weftDetailRepository.saveAll(wefts);
        }

        return new WovenFabricMasterDTO(saved);
    }

    public WovenFabricMasterDTO getFabricMasterById(Long id) {
        WovenFabricMaster entity = wovenFabricMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FabricMaster not found with ID: " + id));
        return new WovenFabricMasterDTO(entity);
    }

    public List<WovenFabricMasterDTO> getAllFabricMasters() {
        return wovenFabricMasterRepository.findAll()
                .stream()
                .map(WovenFabricMasterDTO::new)
                .collect(Collectors.toList());
    }

    public WovenFabricMasterDTO updateFabricMaster(Long id, WovenFabricMasterDTO dto) {
        WovenFabricMaster existing = wovenFabricMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FabricMaster not found with ID: " + id));
        mapDtoToEntity(dto, existing);
        WovenFabricMaster updated = wovenFabricMasterRepository.save(existing);

        // Optional: Update warp and weft details if needed

        return new WovenFabricMasterDTO(updated);
    }

//    public void deleteFabricMaster(Long id) {
//        if (!wovenFabricMasterRepository.existsById(id)) {
//            throw new IllegalArgumentException("FabricMaster not found with ID: " + id);
//        }
//        wovenFabricMasterRepository.deleteById(id);
//    }

    private void mapDtoToEntity(WovenFabricMasterDTO dto, WovenFabricMaster entity) {
        entity.setFabricType(dto.getFabricType());
        entity.setFabricCategoryId(dto.getFabricCategoryId());
        entity.setWovenFabricId(dto.getWovenFabricId());
        entity.setFabricCode(dto.getFabricCode());
        entity.setFabricName(dto.getFabricName());
        entity.setContent(dto.getContent());
        entity.setWeave(dto.getWeave());
        entity.setFabricQuality(dto.getFabricQuality());
        entity.setUom(dto.getUom());
        entity.setEpi(dto.getEpi());
        entity.setPpi(dto.getPpi());
        entity.setGreigeCode(dto.getGreigeCode());
        entity.setTotalEnds(dto.getTotalEnds());
        entity.setGsm(dto.getGsm());
        entity.setGlm(dto.getGlm());
        entity.setIgst(dto.getIgst());
        entity.setCgst(dto.getCgst());
        entity.setSgst(dto.getSgst());
        entity.setStdValue(dto.getStdValue());
        entity.setFabricImageUrl(dto.getFabricImageUrl());
    }

   
    public String getFabricDetails(Long id) {
        return wovenFabricMasterRepository.getFabricDetailsById(id);
    }
    
//    public List<WovenFabricMasterDTO> getFabricByFabricTypeId(Short fabricTypeId) {
//        List<WovenFabricMaster> subCategories = wovenFabricMasterRepository.findByFabricDetailsFabricTypeId(fabricTypeId);
//        return subCategories.stream()
//                .map(WovenFabricMasterDTO::new)
//                .collect(Collectors.toList());
//    }
    public void deleteFabricMaster(Long id) {
        // Check if category exists first
        if (!wovenFabricMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("Woven Fabric not found with id: " + id);
        }
        
        try {
        	wovenFabricMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Woven Fabric because it is referenced by other");
        }
    }
    

}

