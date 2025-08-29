package com.tech3.erp.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tech3.erp.dto.FlangeDTO;
import com.tech3.erp.entity.Flange;
import com.tech3.erp.repository.FlangeRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlangeService {

    private final FlangeRepository flangeRepository;

    public FlangeService(FlangeRepository flangeRepository) {
        this.flangeRepository = flangeRepository;
    }

    public FlangeDTO createFlange(FlangeDTO flangeDTO) {
        Flange flange = new Flange();
        flange.setFlangeNo(flangeDTO.getFlangeNo());

        return new FlangeDTO(flangeRepository.save(flange));
    }

    public FlangeDTO getFlangeById(Long id) {
    	Flange flange = flangeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flange not found"));
        return new FlangeDTO(flange);
    }

    public List<FlangeDTO> getAllFlanges() {
        return flangeRepository.findAll()
                .stream()
                .map(FlangeDTO::new)
                .collect(Collectors.toList());
    }

    public FlangeDTO updateFlange(Long id, FlangeDTO flangeDTO) {
    	Flange flange = flangeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flang not found"));

    	flange.setFlangeNo(flangeDTO.getFlangeNo());
    	flange.setActiveFlag(flangeDTO.getActiveFlag());

        return new FlangeDTO(flangeRepository.save(flange));
    }
    
//    public void deleteFlange(Long id) {
//        if (!flangeRepository.existsById(id)) {
//            throw new IllegalArgumentException("Flang not found");
//        }
//        flangeRepository.deleteById(id);
//    }
    
    public void deleteFlange(Long id) {
        // Check if category exists first
        if (!flangeRepository.existsById(id)) {
            throw new EntityNotFoundException("Flange not found with id: " + id);
        }
        
        try {
        	flangeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Flange because it is referenced by other");
        }
    }
    

}
