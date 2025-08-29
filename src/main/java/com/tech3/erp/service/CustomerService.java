package com.tech3.erp.service;

import com.tech3.erp.dto.CustomerDTO;
import com.tech3.erp.entity.Address;
import com.tech3.erp.entity.City;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.Customer;
import com.tech3.erp.entity.State;
import com.tech3.erp.repository.AddressRepository;
import com.tech3.erp.repository.CityRepository;
import com.tech3.erp.repository.CountryRepository;
import com.tech3.erp.repository.CustomerRepository;
import com.tech3.erp.repository.StateRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public CustomerService(CustomerRepository customerRepository,
                           AddressRepository addressRepository,
                           CountryRepository countryRepository,
                           StateRepository stateRepository,
                           CityRepository cityRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public CustomerDTO createCustomer(CustomerDTO dto) {
        Address address = new Address();
        address.setLine1(dto.getAddress().getLine1());
        address.setLine2(dto.getAddress().getLine2());
        address.setPinCode(dto.getAddress().getPinCode());
        address.setCountry(getCountryById(dto.getAddress().getCountryId()));
        address.setState(getStateById(dto.getAddress().getStateId()));
        address.setCity(getCityById(dto.getAddress().getCityId()));

        Address savedAddress = addressRepository.save(address);

        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setGstno(dto.getGstNo());
        customer.setPancard(dto.getPanCard());
        customer.setMobileno(dto.getMobileNo());
        customer.setEmail(dto.getEmail());
        customer.setIecCode(dto.getIecCode());
        customer.setCinNo(dto.getCinNo());
        customer.setTinNo(dto.getTinNo());
        customer.setMsmeUdyam(dto.getMsmeUdyam());
        customer.setAddress(savedAddress);
        customer.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerDTO(savedCustomer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return new CustomerDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        customer.setCustomerName(dto.getCustomerName());
        customer.setGstno(dto.getGstNo());
        customer.setPancard(dto.getPanCard());
        customer.setMobileno(dto.getMobileNo());
        customer.setEmail(dto.getEmail());
        customer.setIecCode(dto.getIecCode());
        customer.setCinNo(dto.getCinNo());
        customer.setTinNo(dto.getTinNo());
        customer.setMsmeUdyam(dto.getMsmeUdyam());
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

        Customer updatedCustomer = customerRepository.save(customer);
        return new CustomerDTO(updatedCustomer);
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
//        if (!customerRepository.existsById(id)) {
//            throw new IllegalArgumentException("Customer not found");
//        }
//        customerRepository.deleteById(id);
//    }
    
    public void deleteCustomer(Long id) {
        // Check if category exists first
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("Customer not found with id: " + id);
        }
        
        try {
        	customerRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Customer because it is referenced by other entities");
        }
    }
}
