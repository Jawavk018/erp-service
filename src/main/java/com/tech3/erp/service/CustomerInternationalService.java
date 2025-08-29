package com.tech3.erp.service;

import com.tech3.erp.dto.CustomerInternationalDTO;
import com.tech3.erp.entity.Address;
import com.tech3.erp.entity.City;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.CustomerInternational;
import com.tech3.erp.entity.State;
import com.tech3.erp.repository.AddressRepository;
import com.tech3.erp.repository.CityRepository;
import com.tech3.erp.repository.CountryRepository;
import com.tech3.erp.repository.CustomerInternationalRepository;
import com.tech3.erp.repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerInternationalService {

    private final CustomerInternationalRepository customerInternationalRepository;
    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public CustomerInternationalService(CustomerInternationalRepository customerInternationalRepository,
                           AddressRepository addressRepository,
                           CountryRepository countryRepository,
                           StateRepository stateRepository,
                           CityRepository cityRepository) {
        this.customerInternationalRepository = customerInternationalRepository;
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public CustomerInternationalDTO createCustomer(CustomerInternationalDTO dto) {
        Address address = new Address();
        address.setLine1(dto.getAddress().getLine1());
        address.setLine2(dto.getAddress().getLine2());
        address.setPinCode(dto.getAddress().getPinCode());
        address.setCountry(getCountryById(dto.getAddress().getCountryId()));
        address.setState(getStateById(dto.getAddress().getStateId()));
        address.setCity(getCityById(dto.getAddress().getCityId()));

        Address savedAddress = addressRepository.save(address);

        CustomerInternational customer = new CustomerInternational();
        customer.setCustomerName(dto.getCustomerName());
        customer.setMobileno(dto.getMobileNo());
        customer.setEmail(dto.getEmail());
        customer.setIecCode(dto.getIecCode());
        customer.setCinNo(dto.getCinNo());
        customer.setTinNo(dto.getTinNo());
        customer.setIrcNo(dto.getIrcNo());
        customer.setBinNo(dto.getBinNo());
        customer.setAddress(savedAddress);
        customer.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        CustomerInternational savedCustomer = customerInternationalRepository.save(customer);
        return new CustomerInternationalDTO(savedCustomer);
    }

    public CustomerInternationalDTO getCustomerById(Long id) {
    	CustomerInternational customer = customerInternationalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return new CustomerInternationalDTO(customer);
    }

    public List<CustomerInternationalDTO> getAllCustomers() {
        return customerInternationalRepository.findAll().stream()
                .map(CustomerInternationalDTO::new)
                .collect(Collectors.toList());
    }

    public CustomerInternationalDTO updateCustomer(Long id, CustomerInternationalDTO dto) {
    	CustomerInternational customer = customerInternationalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        customer.setCustomerName(dto.getCustomerName());
        customer.setMobileno(dto.getMobileNo());
        customer.setEmail(dto.getEmail());
        customer.setIecCode(dto.getIecCode());
        customer.setCinNo(dto.getCinNo());
        customer.setTinNo(dto.getTinNo());
        customer.setIrcNo(dto.getIrcNo());
        customer.setBinNo(dto.getBinNo());
        customer.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        if (dto.getAddress() != null) {
            Address address = new Address();
            address.setLine1(dto.getAddress().getLine1());
            address.setLine2(dto.getAddress().getLine2());
            address.setPinCode(dto.getAddress().getPinCode());
            address.setCountry(getCountryById(dto.getAddress().getCountryId()));
            address.setState(getStateById(dto.getAddress().getStateId()));
            address.setCity(getCityById(dto.getAddress().getCityId()));

            Address savedAddress = addressRepository.save(address);
            customer.setAddress(savedAddress);
        }

        CustomerInternational updatedCustomer = customerInternationalRepository.save(customer);
        return new CustomerInternationalDTO(updatedCustomer);
    }

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
    
//    public void deleteCustomer(Long id) {
//        if (!customerInternationalRepository.existsById(id)) {
//            throw new IllegalArgumentException("Customer not found");
//        }
//        customerInternationalRepository.deleteById(id);
//    }
    
    public void deleteCustomer(Long id) {
        // Check if category exists first
        if (!customerInternationalRepository.existsById(id)) {
            throw new EntityNotFoundException("Customer not found with id: " + id);
        }
        
        try {
        	customerInternationalRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Customer because it is referenced by other entities");
        }
    }
}
