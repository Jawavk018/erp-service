package com.tech3.erp.service;

import com.tech3.erp.dto.ConsigneeDTO;
import com.tech3.erp.entity.Address;
import com.tech3.erp.entity.City;
import com.tech3.erp.entity.Consignee;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.State;
import com.tech3.erp.repository.AddressRepository;
import com.tech3.erp.repository.CityRepository;
import com.tech3.erp.repository.ConsigneeRepository;
import com.tech3.erp.repository.CountryRepository;
import com.tech3.erp.repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsigneeService {

    private final ConsigneeRepository consigneeRepository;
    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public ConsigneeService(ConsigneeRepository consigneeRepository,
                           AddressRepository addressRepository,
                           CountryRepository countryRepository,
                           StateRepository stateRepository,
                           CityRepository cityRepository) {
        this.consigneeRepository = consigneeRepository;
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public ConsigneeDTO createConsignee(ConsigneeDTO dto) {
        Address address = new Address();
        address.setLine1(dto.getAddress().getLine1());
        address.setLine2(dto.getAddress().getLine2());
        address.setCountry(getCountryById(dto.getAddress().getCountryId()));
        address.setState(getStateById(dto.getAddress().getStateId()));
        address.setCity(getCityById(dto.getAddress().getCityId()));

        Address savedAddress = addressRepository.save(address);

        Consignee consignee = new Consignee();
        consignee.setConsigneeName(dto.getConsigneeName());
        consignee.setGstno(dto.getGstNo());
        consignee.setPancard(dto.getPanCard());
        consignee.setMobileno(dto.getMobileNo());
        consignee.setEmail(dto.getEmail());
        consignee.setAddress(savedAddress);
        consignee.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        Consignee savedConsignee = consigneeRepository.save(consignee);
        return new ConsigneeDTO(savedConsignee);
    }

    public ConsigneeDTO getConsigneeById(Long id) {
        Consignee consignee = consigneeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consignee not found"));
        return new ConsigneeDTO(consignee);
    }

    public List<ConsigneeDTO> getAllConsignee() {
        return consigneeRepository.findAll().stream()
                .map(ConsigneeDTO::new)
                .collect(Collectors.toList());
    }

    public ConsigneeDTO updateConsignee(Long id, ConsigneeDTO dto) {
        Consignee consignee = consigneeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consignee not found"));

        consignee.setConsigneeName(dto.getConsigneeName());
        consignee.setGstno(dto.getGstNo());
        consignee.setPancard(dto.getPanCard());
        consignee.setMobileno(dto.getMobileNo());
        consignee.setEmail(dto.getEmail());
        consignee.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        if (dto.getAddress() != null) {
            Address address = new Address();
            address.setLine1(dto.getAddress().getLine1());
            address.setLine2(dto.getAddress().getLine2());
            address.setCountry(getCountryById(dto.getAddress().getCountryId()));
            address.setState(getStateById(dto.getAddress().getStateId()));
            address.setCity(getCityById(dto.getAddress().getCityId()));

            Address savedAddress = addressRepository.save(address);
            consignee.setAddress(savedAddress);
        }

        Consignee updatedConsignee = consigneeRepository.save(consignee);
        return new ConsigneeDTO(updatedConsignee);
    }

//    public void deleteConsignee(Long id) {
//        if (!consigneeRepository.existsById(id)) {
//            throw new IllegalArgumentException("Consignee not found");
//        }
//        consigneeRepository.deleteById(id);
//    }

    // Utility methods to fetch referenced entities
    private Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country ID"));
    }

    private State getStateById(Long id) {
        return stateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid state ID"));
    }

    private City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid city ID"));
    }
    
    public void deleteConsignee(Long id) {
        // Check if category exists first
        if (!consigneeRepository.existsById(id)) {
            throw new EntityNotFoundException("Consignee not found with id: " + id);
        }
        
        try {
        	consigneeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Consignee because it is referenced by other entities");
        }
    }
    
}
