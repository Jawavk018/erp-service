package com.tech3.erp.service;

import com.tech3.erp.dto.JobworkFabricReceiveDTO;
import com.tech3.erp.entity.JobworkFabricReceive;
import com.tech3.erp.entity.JobworkFabricReceiveItem;
import com.tech3.erp.entity.LotEntry;
import com.tech3.erp.entity.PieceEntry;
import com.tech3.erp.repository.JobworkFabricReceiveRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobworkFabricReceiveService {

    @Autowired
    private JobworkFabricReceiveRepository jobworkFabricReceiveRepository;

    @Transactional
    public JobworkFabricReceive createJobworkFabricReceive(JobworkFabricReceiveDTO dto) {
        JobworkFabricReceive jobReceive = new JobworkFabricReceive();
        jobReceive.setWeavingContractId(dto.getWeavingContractId());
        jobReceive.setVendorId(dto.getVendorId());
        jobReceive.setRemarks(dto.getRemarks());
        jobReceive.setJobFabricReceiveDate(LocalDate.now());
        jobReceive.setActiveFlag(true);

        List<JobworkFabricReceiveItem> jobReceiveItems = dto.getJobworkFabricReceiveItemsDtl().stream().map(itemDto -> {
            JobworkFabricReceiveItem item = new JobworkFabricReceiveItem();
            item.setWeavingContractItemId(itemDto.getWeavingContractItemId());
            item.setQuantityReceived(itemDto.getQuantityReceived());
            item.setPrice(itemDto.getPrice());
            item.setJobworkFabricReceive(jobReceive);
            item.setActiveFlag(true);

            List<PieceEntry> pieceEntries = itemDto.getPieceEntries().stream().map(pieceDto -> {
            	PieceEntry piece = new PieceEntry();
            	piece.setPieceNumber(pieceDto.getPieceNumber());
            	piece.setQuantity(pieceDto.getQuantity()); // ✅ received quantity
            	piece.setWeight(pieceDto.getWeight()); // ✅ rejected quantity
            	piece.setCost(pieceDto.getCost());
            	piece.setRemarks(pieceDto.getRemarks());
            	piece.setJobworkFabricReceiveItem(item);
            	piece.setActiveFlag(true);
                return piece;
            }).collect(Collectors.toList());

            item.setPieceEntries(pieceEntries);
            return item;
        }).collect(Collectors.toList());

        jobReceive.setItems(jobReceiveItems);
        return jobworkFabricReceiveRepository.save(jobReceive);
    }

    // Get all Purchase Inward records
    public List<JobworkFabricReceive> getAllJobworkFabricReceive() {
        return jobworkFabricReceiveRepository.findAll();
    }

    // Get a Purchase Inward by ID
    public JobworkFabricReceive getJobworkFabricReceiveById(Long id) {
        Optional<JobworkFabricReceive> jobReceive = jobworkFabricReceiveRepository.findById(id);
        return jobReceive.orElse(null);
    }
    
 // Update a JobworkFabricReceive by ID
    @Transactional
    public JobworkFabricReceive updateJobworkFabricReceive(Long id, JobworkFabricReceiveDTO dto) {
        JobworkFabricReceive jobReceive = jobworkFabricReceiveRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("JobworkFabricReceive not found with id: " + id));

        // Update fields
        jobReceive.setWeavingContractId(dto.getWeavingContractId());
        jobReceive.setVendorId(dto.getVendorId());
        jobReceive.setRemarks(dto.getRemarks());
        // Optionally: jobReceive.setJobFabricReceiveDate(LocalDateTime.now()); // update date or not

        // Remove old items (assuming orphanRemoval/cascade on child entities)
        jobReceive.getItems().clear();

        List<JobworkFabricReceiveItem> jobReceiveItems = dto.getJobworkFabricReceiveItemsDtl().stream().map(itemDto -> {
            JobworkFabricReceiveItem item = new JobworkFabricReceiveItem();
            item.setWeavingContractItemId(itemDto.getWeavingContractItemId());
            item.setQuantityReceived(itemDto.getQuantityReceived());
            item.setPrice(itemDto.getPrice());
            item.setJobworkFabricReceive(jobReceive);
            item.setActiveFlag(true);

            List<PieceEntry> pieceEntries = itemDto.getPieceEntries().stream().map(pieceDto -> {
                PieceEntry piece = new PieceEntry();
                piece.setPieceNumber(pieceDto.getPieceNumber());
                piece.setQuantity(pieceDto.getQuantity());
                piece.setWeight(pieceDto.getWeight());
                piece.setCost(pieceDto.getCost());
                piece.setRemarks(pieceDto.getRemarks());
                piece.setJobworkFabricReceiveItem(item);
                piece.setActiveFlag(true);
                return piece;
            }).collect(Collectors.toList());

            item.setPieceEntries(pieceEntries);
            return item;
        }).collect(Collectors.toList());

        jobReceive.getItems().addAll(jobReceiveItems);

        return jobworkFabricReceiveRepository.save(jobReceive);
    }

    
    // Delete a Purchase Inward by ID (Soft Delete or Physical Delete)
//    public boolean deleteJobworkFabricReceive(Long id) {
//        Optional<JobworkFabricReceive> jobReceiveOpt = jobworkFabricReceiveRepository.findById(id);
//        if (jobReceiveOpt.isPresent()) {
//        	JobworkFabricReceive jobReceive = jobReceiveOpt.get();
//            jobworkFabricReceiveRepository.delete(jobReceive); // you can change to soft-delete if needed
//            return true;
//        } else {
//            return false;
//        }
//    }
    public void deleteJobworkFabricReceive(Long id) {
        // Check if category exists first
        if (!jobworkFabricReceiveRepository.existsById(id)) {
            throw new EntityNotFoundException("JobworkFabricReceive not found with id: " + id);
        }   
        try {
        	jobworkFabricReceiveRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete JobworkFabricReceive because it is referenced by other");
        }
    }
}

