package com.tech3.erp.service;

import com.tech3.erp.dto.CityDTO;
import com.tech3.erp.dto.StateDTO;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.State;
import com.tech3.erp.repository.CountryRepository;
import com.tech3.erp.repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    public StateService(StateRepository stateRepository, CountryRepository countryRepository) {
        this.stateRepository = stateRepository;
        this.countryRepository = countryRepository;
    }

    public StateDTO createState(StateDTO stateDTO) {
        Country country = countryRepository.findById(stateDTO.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Country not found with ID: " + stateDTO.getCountryId()));

        State state = new State();
        state.setCountry(country);
        state.setStateName(stateDTO.getStateName());
        state.setActiveFlag(stateDTO.getActiveFlag());

        return new StateDTO(stateRepository.save(state));
    }

    public StateDTO getStateById(Long id) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("State not found with ID: " + id));
        return new StateDTO(state);
    }

    public List<StateDTO> getAllStates() {
        return stateRepository.findAll()
                .stream()
                .map(StateDTO::new)
                .collect(Collectors.toList());
    }

    
    public List<StateDTO> getStatesByCountryId(Long countryId) {
        return stateRepository.findByCountryId(countryId)
                .stream()
                .map(StateDTO::new)
                .collect(Collectors.toList());
    }

    public StateDTO updateState(Long id, StateDTO stateDTO) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("State not found with ID: " + id));

        Country country = countryRepository.findById(stateDTO.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Country not found with ID: " + stateDTO.getCountryId()));

        state.setCountry(country);
        state.setStateName(stateDTO.getStateName());
        state.setActiveFlag(stateDTO.getActiveFlag());

        return new StateDTO(stateRepository.save(state));
    }

//    public void deleteState(Long id) {
//        if (!stateRepository.existsById(id)) {
//            throw new IllegalArgumentException("State not found with ID: " + id);
//        }
//        stateRepository.deleteById(id);
//    }
    public void deleteState(Long id) {
        // Check if category exists first
        if (!stateRepository.existsById(id)) {
            throw new EntityNotFoundException("State not found with id: " + id);
        }
        
        try {
        	stateRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete State because it is referenced by other");
        }
    }
    
}
