package com.tech3.erp.service;

import com.tech3.erp.dto.CityDTO;
import com.tech3.erp.dto.StateDTO;
import com.tech3.erp.entity.City;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.State;
import com.tech3.erp.repository.CityRepository;
import com.tech3.erp.repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    public CityService(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    public CityDTO createCity(CityDTO cityDTO) {
        State state = stateRepository.findById(cityDTO.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("State not found with ID: " + cityDTO.getStateId()));

        City city = new City();
        city.setState(state);
        city.setCityName(cityDTO.getCityName());
        city.setActiveFlag(cityDTO.getActiveFlag());
        
        // Set country from the state
        city.setCountry(state.getCountry()); 

        return new CityDTO(cityRepository.save(city));
    }

    public CityDTO getCityById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with ID: " + id));
        return new CityDTO(city);
    }

    public List<CityDTO> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
    }
    
    public CityDTO updateCity(Long id, CityDTO cityDTO) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with ID: " + id));

        State state = stateRepository.findById(cityDTO.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("State not found with ID: " + cityDTO.getStateId()));

        city.setState(state);
        city.setCityName(cityDTO.getCityName());
        city.setActiveFlag(cityDTO.getActiveFlag());

        return new CityDTO(cityRepository.save(city));
    }

//    public void deleteCity(Long id) {
//        if (!cityRepository.existsById(id)) {
//            throw new IllegalArgumentException("City not found with ID: " + id);
//        }
//        cityRepository.deleteById(id);
//    }
    public void deleteCity(Long id) {
        // Check if category exists first
        if (!cityRepository.existsById(id)) {
            throw new EntityNotFoundException("City not found with id: " + id);
        }
        
        try {
        	cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete City because it is referenced by other entities");
        }
    }

	
}
