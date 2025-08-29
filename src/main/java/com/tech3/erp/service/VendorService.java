package com.tech3.erp.service;

import com.tech3.erp.dto.VendorDTO;
import com.tech3.erp.entity.Address;
import com.tech3.erp.entity.City;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.State;
import com.tech3.erp.entity.Vendor;
import com.tech3.erp.repository.AddressRepository;
import com.tech3.erp.repository.CityRepository;
import com.tech3.erp.repository.CountryRepository;
import com.tech3.erp.repository.StateRepository;
import com.tech3.erp.repository.VendorRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;
    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public VendorService(VendorRepository vendorRepository,
                         AddressRepository addressRepository,
                         CountryRepository countryRepository,
                         StateRepository stateRepository,
                         CityRepository cityRepository) {
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public VendorDTO createVendor(VendorDTO dto) {
        Address address = new Address();
        address.setLine1(dto.getAddress().getLine1());
        address.setLine2(dto.getAddress().getLine2());
        address.setCountry(getCountryById(dto.getAddress().getCountryId()));
        address.setState(getStateById(dto.getAddress().getStateId()));
        address.setCity(getCityById(dto.getAddress().getCityId()));

        Address savedAddress = addressRepository.save(address);

        Vendor vendor = new Vendor();
        vendor.setVendorName(dto.getVendorName());
        vendor.setGstno(dto.getGstno());
        vendor.setPancard(dto.getPancard());
        vendor.setMobileno(dto.getMobileno());
        vendor.setEmail(dto.getEmail());
        vendor.setPhotoUrl(dto.getPhotoUrl());
        vendor.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);
        vendor.setAddress(savedAddress);

        Vendor savedVendor = vendorRepository.save(vendor);
        return new VendorDTO(savedVendor);
    }

    public VendorDTO getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));
        return new VendorDTO(vendor);
    }

    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll().stream()
                .map(VendorDTO::new)
                .collect(Collectors.toList());
    }

    public VendorDTO updateVendor(Long id, VendorDTO dto) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        vendor.setVendorName(dto.getVendorName());
        vendor.setGstno(dto.getGstno());
        vendor.setPancard(dto.getPancard());
        vendor.setMobileno(dto.getMobileno());
        vendor.setEmail(dto.getEmail());
        vendor.setPhotoUrl(dto.getPhotoUrl());
        vendor.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        if (dto.getAddress() != null) {
            Address address = new Address();
            address.setLine1(dto.getAddress().getLine1());
            address.setLine2(dto.getAddress().getLine2());
            address.setCountry(getCountryById(dto.getAddress().getCountryId()));
            address.setState(getStateById(dto.getAddress().getStateId()));
            address.setCity(getCityById(dto.getAddress().getCityId()));

            Address savedAddress = addressRepository.save(address);
            vendor.setAddress(savedAddress);
        }

        Vendor updatedVendor = vendorRepository.save(vendor);
        return new VendorDTO(updatedVendor);
    }

//    public void deleteVendor(Long id) {
//        if (!vendorRepository.existsById(id)) {
//            throw new IllegalArgumentException("Vendor not found");
//        }
//        vendorRepository.deleteById(id);
//    }
    public void deleteVendor(Long id) {
        // Check if category exists first
        if (!vendorRepository.existsById(id)) {
            throw new EntityNotFoundException("Vendor not found with id: " + id);
        }
        
        try {
        	vendorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Vendor because it is referenced by other");
        }
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
}
