package com.tech3.erp.service;

import com.tech3.erp.dto.AddressDTO;
import com.tech3.erp.entity.Address;
import com.tech3.erp.entity.City;
import com.tech3.erp.entity.Country;
import com.tech3.erp.entity.State;
import com.tech3.erp.repository.AddressRepository;
import com.tech3.erp.repository.CityRepository;
import com.tech3.erp.repository.CountryRepository;
import com.tech3.erp.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public AddressService(AddressRepository addressRepository,
                          CountryRepository countryRepository,
                          StateRepository stateRepository,
                          CityRepository cityRepository) {
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public AddressDTO createAddress(AddressDTO dto) {
        Address address = new Address();
        address.setLine1(dto.getLine1());
        address.setLine2(dto.getLine2());
        address.setPinCode(dto.getPinCode());
        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));
        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("State not found"));
        City city = cityRepository.findById(dto.getCityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found"));

        address.setCountry(country);
        address.setState(state);
        address.setCity(city);
        address.setActiveFlag(dto.getActiveFlag() != null ? dto.getActiveFlag() : true);

        return new AddressDTO(addressRepository.save(address));
    }

    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));
        return new AddressDTO(address);
    }

    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(AddressDTO::new)
                .collect(Collectors.toList());
    }

    public AddressDTO updateAddress(Long id, AddressDTO dto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));

        address.setLine1(dto.getLine1());
        address.setLine2(dto.getLine2());
        address.setPinCode(dto.getPinCode());
        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));
        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("State not found"));
        City city = cityRepository.findById(dto.getCityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found"));

        address.setCountry(country);
        address.setState(state);
        address.setCity(city);
        address.setActiveFlag(dto.getActiveFlag());

        return new AddressDTO(addressRepository.save(address));
    }

    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new IllegalArgumentException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}
