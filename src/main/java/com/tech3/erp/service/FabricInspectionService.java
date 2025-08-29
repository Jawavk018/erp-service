package com.tech3.erp.service;

import com.tech3.erp.dto.FabricInspectionDTO;
import com.tech3.erp.dto.InspectionDetailDTO;
import com.tech3.erp.dto.InspectionEntryDTO;
import com.tech3.erp.entity.FabricInspection;
import com.tech3.erp.entity.InspectionDetail;
import com.tech3.erp.entity.InspectionEntry;
import com.tech3.erp.entity.JobworkFabricReceive;
import com.tech3.erp.repository.FabricInspectionRepository;
import com.tech3.erp.repository.InspectionDetailRepository;
import com.tech3.erp.repository.InspectionEntryRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FabricInspectionService {

    @Autowired
    private FabricInspectionRepository fabricInspectionRepository;
    
    @Autowired
    private InspectionDetailRepository inspectionDetailRepository;
    
    @Autowired
    private InspectionEntryRepository inspectionEntryRepository;
    
    @Autowired
    private RollNumberGenerator rollNumberGenerator;

    @Transactional
    public FabricInspection createFabricInspection(FabricInspectionDTO dto) {
        FabricInspection inspection = new FabricInspection();
        inspection.setInspectionDate(LocalDate.now());
        inspection.setLoomNo(dto.getLoomNo());
        inspection.setVendorId(dto.getVendorId());
        inspection.setFabricQuality(dto.getFabricQuality());
        inspection.setDoffMeters(dto.getDoffMeters());
        inspection.setDoffWeight(dto.getDoffWeight());
        inspection.setActiveFlag(true);

        FabricInspection savedInspection = fabricInspectionRepository.save(inspection);

        if (dto.getInspectionDetails() != null) {
            List<InspectionDetail> details = dto.getInspectionDetails().stream()
                    .map(detailDto -> {
                        InspectionDetail detail = new InspectionDetail();
                        detail.setFabricInspection(savedInspection);
                        detail.setRollNo(rollNumberGenerator.generateRollNumber());
                        detail.setDoffMeters(detailDto.getDoffMeters());
                        detail.setInspectedMeters(detailDto.getInspectedMeters());
                        detail.setWeight(detailDto.getWeight());
                        detail.setTotalDefectPoints(detailDto.getTotalDefectPoints());
                        detail.setDefectCounts(detailDto.getDefectCounts());
                        detail.setGrade(detailDto.getGrade());
                        detail.setActiveFlag(true);
                        return detail;
                    })
                    .collect(Collectors.toList());
            
            inspectionDetailRepository.saveAll(details);
            savedInspection.setInspectionDetails(details);
        }

        if (dto.getInspectionEntries() != null) {
            List<InspectionEntry> entries = dto.getInspectionEntries().stream()
                    .map(entryDto -> {
                        InspectionEntry entry = new InspectionEntry();
                        entry.setFabricInspection(savedInspection);
                        entry.setDefectedMeters(entryDto.getDefectedMeters());
                        entry.setFromMeters(entryDto.getFromMeters());
                        entry.setToMeters(entryDto.getToMeters());
                        entry.setDefectTypeId(entryDto.getDefectTypeId());
                        entry.setDefectPoints(entryDto.getDefectPoints());
                        entry.setInspectionId(entryDto.getInspectionId());
                        entry.setActiveFlag(true);
                        return entry;
                    })
                    .collect(Collectors.toList());
            
            inspectionEntryRepository.saveAll(entries);
            savedInspection.setInspectionEntries(entries);
        }

//        return mapToDTO(savedInspection);
        return fabricInspectionRepository.save(inspection);
    }

    public List<FabricInspectionDTO> getAllFabricInspections() {
        return fabricInspectionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    
 // Get a Purchase Inward by ID
    public FabricInspection getFabricInspectionById(Long id) {
        Optional<FabricInspection> inspection = fabricInspectionRepository.findById(id);
        return inspection.orElse(null);
    }
    
    @Transactional
    public FabricInspection updateFabricInspection(Long id, FabricInspectionDTO dto) {
        Optional<FabricInspection> optionalInspection = fabricInspectionRepository.findById(id);
        if (!optionalInspection.isPresent()) {
            throw new RuntimeException("FabricInspection not found with id: " + id);
        }
        FabricInspection inspection = optionalInspection.get();
        inspection.setInspectionDate(dto.getInspectionDate());
        inspection.setLoomNo(dto.getLoomNo());
        inspection.setVendorId(dto.getVendorId());
        inspection.setFabricQuality(dto.getFabricQuality());
        inspection.setDoffMeters(dto.getDoffMeters());
        inspection.setDoffWeight(dto.getDoffWeight());
        inspection.setActiveFlag(dto.getActiveFlag());

        // Remove old details and entries (orphanRemoval/cascade recommended)
        if (inspection.getInspectionDetails() != null) {
            inspectionDetailRepository.deleteAll(inspection.getInspectionDetails());
            inspection.getInspectionDetails().clear();
        }
        if (inspection.getInspectionEntries() != null) {
            inspectionEntryRepository.deleteAll(inspection.getInspectionEntries());
            inspection.getInspectionEntries().clear();
        }

        // Add new details
        if (dto.getInspectionDetails() != null) {
            List<InspectionDetail> details = dto.getInspectionDetails().stream()
                    .map(detailDto -> {
                        InspectionDetail detail = new InspectionDetail();
                        detail.setFabricInspection(inspection);
                        // For update, reuse rollNo if present, else generate
                        detail.setRollNo(detailDto.getRollNo() != null ? detailDto.getRollNo() : rollNumberGenerator.generateRollNumber());
                        detail.setDoffMeters(detailDto.getDoffMeters());
                        detail.setInspectedMeters(detailDto.getInspectedMeters());
                        detail.setWeight(detailDto.getWeight());
                        detail.setTotalDefectPoints(detailDto.getTotalDefectPoints());
                        detail.setDefectCounts(detailDto.getDefectCounts());
                        detail.setGrade(detailDto.getGrade());
                        detail.setActiveFlag(true);
                        return detail;
                    })
                    .collect(Collectors.toList());
            inspectionDetailRepository.saveAll(details);
            inspection.setInspectionDetails(details);
        }

        // Add new entries
        if (dto.getInspectionEntries() != null) {
            List<InspectionEntry> entries = dto.getInspectionEntries().stream()
                    .map(entryDto -> {
                        InspectionEntry entry = new InspectionEntry();
                        entry.setFabricInspection(inspection);
                        entry.setDefectedMeters(entryDto.getDefectedMeters());
                        entry.setFromMeters(entryDto.getFromMeters());
                        entry.setToMeters(entryDto.getToMeters());
                        entry.setDefectTypeId(entryDto.getDefectTypeId());
                        entry.setDefectPoints(entryDto.getDefectPoints());
                        entry.setInspectionId(entryDto.getInspectionId());
                        entry.setActiveFlag(true);
                        return entry;
                    })
                    .collect(Collectors.toList());
            inspectionEntryRepository.saveAll(entries);
            inspection.setInspectionEntries(entries);
        }

        return fabricInspectionRepository.save(inspection);
    }


    public boolean deleteFabricInspection(Long id) {
        Optional<FabricInspection> inspectionOpt = fabricInspectionRepository.findById(id);
        if (inspectionOpt.isPresent()) {
            FabricInspection inspection = inspectionOpt.get();
            inspection.setActiveFlag(false);
            fabricInspectionRepository.save(inspection); // Soft delete
            return true;
        }
        return false;
    }

    private FabricInspectionDTO mapToDTO(FabricInspection inspection) {
        FabricInspectionDTO dto = new FabricInspectionDTO();
        dto.setId(inspection.getId());
        dto.setInspectionDate(inspection.getInspectionDate());
        dto.setLoomNo(inspection.getLoomNo());
        dto.setVendorId(inspection.getVendorId());
        dto.setFabricQuality(inspection.getFabricQuality());
        dto.setDoffMeters(inspection.getDoffMeters());
        dto.setDoffWeight(inspection.getDoffWeight());
        dto.setActiveFlag(inspection.getActiveFlag());

        if (inspection.getInspectionDetails() != null) {
            List<InspectionDetailDTO> detailDTOs = inspection.getInspectionDetails().stream()
                    .map(this::mapDetailToDTO)
                    .collect(Collectors.toList());
            dto.setInspectionDetails(detailDTOs);
        }

        if (inspection.getInspectionEntries() != null) {
            List<InspectionEntryDTO> entryDTOs = inspection.getInspectionEntries().stream()
                    .map(this::mapEntryToDTO)
                    .collect(Collectors.toList());
            dto.setInspectionEntries(entryDTOs);
        }

        return dto;
    }

    private InspectionDetailDTO mapDetailToDTO(InspectionDetail detail) {
        InspectionDetailDTO dto = new InspectionDetailDTO();
        dto.setId(detail.getId());
        dto.setFabricInspectionId(detail.getFabricInspection().getId());
        dto.setRollNo(detail.getRollNo());
        dto.setDoffMeters(detail.getDoffMeters());
        dto.setInspectedMeters(detail.getInspectedMeters());
        dto.setWeight(detail.getWeight());
        dto.setTotalDefectPoints(detail.getTotalDefectPoints());
        dto.setDefectCounts(detail.getDefectCounts());
        dto.setGrade(detail.getGrade());
        dto.setActiveFlag(detail.getActiveFlag());
        return dto;
    }

    private InspectionEntryDTO mapEntryToDTO(InspectionEntry entry) {
        InspectionEntryDTO dto = new InspectionEntryDTO();
        dto.setId(entry.getId());
        dto.setFabricInspectionId(entry.getFabricInspection().getId());
        dto.setDefectedMeters(entry.getDefectedMeters());
        dto.setFromMeters(entry.getFromMeters());
        dto.setToMeters(entry.getToMeters());
        dto.setDefectTypeId(entry.getDefectTypeId());
        dto.setDefectPoints(entry.getDefectPoints());
        dto.setInspectionId(entry.getInspectionId());
        dto.setActiveFlag(entry.getActiveFlag());
        return dto;
    }
}