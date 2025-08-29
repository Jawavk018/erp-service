package com.tech3.erp.service;

import com.tech3.erp.dto.CurrencyMasterDTO;
import com.tech3.erp.entity.CurrencyMaster;
import com.tech3.erp.repository.CurrencyMasterRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyMasterService {

    private final CurrencyMasterRepository currencyMasterRepository;

    public CurrencyMasterService(CurrencyMasterRepository currencyMasterRepository) {
        this.currencyMasterRepository = currencyMasterRepository;
    }

    public CurrencyMasterDTO createCurrency(CurrencyMasterDTO currencyMasterDTO) {
        CurrencyMaster currency = new CurrencyMaster();
        currency.setCurrencyCode(currencyMasterDTO.getCurrencyCode());
        currency.setCurrencyName(currencyMasterDTO.getCurrencyName());
        currency.setSymbol(currencyMasterDTO.getSymbol());
        currency.setActiveFlag(currencyMasterDTO.getActiveFlag());

        return new CurrencyMasterDTO(currencyMasterRepository.save(currency));
    }

    public CurrencyMasterDTO getCurrencyById(Long id) {
        CurrencyMaster currency = currencyMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Currency not found"));
        return new CurrencyMasterDTO(currency);
    }

    public List<CurrencyMasterDTO> getAllCurrencies() {
        return currencyMasterRepository.findAll()
                .stream()
                .map(CurrencyMasterDTO::new)
                .collect(Collectors.toList());
    }

    public CurrencyMasterDTO updateCurrency(Long id, CurrencyMasterDTO currencyMasterDTO) {
        CurrencyMaster currency = currencyMasterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Currency not found"));

        currency.setCurrencyCode(currencyMasterDTO.getCurrencyCode());
        currency.setCurrencyName(currencyMasterDTO.getCurrencyName());
        currency.setSymbol(currencyMasterDTO.getSymbol());
        currency.setActiveFlag(currencyMasterDTO.getActiveFlag());

        return new CurrencyMasterDTO(currencyMasterRepository.save(currency));
    }

//    public void deleteCurrency(Long id) {
//        if (!currencyMasterRepository.existsById(id)) {
//            throw new IllegalArgumentException("Currency not found");
//        }
//        currencyMasterRepository.deleteById(id);
//    }
    public void deleteCurrency(Long id) {
        // Check if category exists first
        if (!currencyMasterRepository.existsById(id)) {
            throw new EntityNotFoundException("Currency not found with id: " + id);
        }
        
        try {
        	currencyMasterRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Currency because it is referenced by other entities");
        }
    }
    
}
