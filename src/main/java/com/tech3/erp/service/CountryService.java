package com.tech3.erp.service;

import com.tech3.erp.dto.CountryDTO;
import com.tech3.erp.entity.Country;
import com.tech3.erp.repository.CountryRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryDTO createCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setCountryName(countryDTO.getCountryName());

        return new CountryDTO(countryRepository.save(country));
    }

    public CountryDTO getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));
        return new CountryDTO(country);
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(CountryDTO::new)
                .collect(Collectors.toList());
    }

    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));

        country.setCountryName(countryDTO.getCountryName());
        country.setActiveFlag(countryDTO.getActiveFlag());

        return new CountryDTO(countryRepository.save(country));
    }
    
//    public void deleteCountry(Long id) {
//        if (!countryRepository.existsById(id)) {
//            throw new IllegalArgumentException("Country not found");
//        }
//        countryRepository.deleteById(id);
//    }
    
    public void deleteCountry(Long id) {
        // Check if category exists first
        if (!countryRepository.existsById(id)) {
            throw new EntityNotFoundException("Country not found with id: " + id);
        }
        
        try {
        	countryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Country because it is referenced by other entities");
        }
    }

}
