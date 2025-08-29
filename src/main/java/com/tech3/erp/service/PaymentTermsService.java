package com.tech3.erp.service;

import com.tech3.erp.dto.PaymentTermsDTO;
import com.tech3.erp.entity.PaymentTerms;
import com.tech3.erp.repository.PaymentTermsRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentTermsService {

    private final PaymentTermsRepository paymentTermsRepository;

    public PaymentTermsService(PaymentTermsRepository paymentTermsRepository) {
        this.paymentTermsRepository = paymentTermsRepository;
    }

    public PaymentTermsDTO createPaymentTerms(PaymentTermsDTO paymentTermsDTO) {
        PaymentTerms paymentTerms = new PaymentTerms();
        paymentTerms.setTermName(paymentTermsDTO.getTermName());
        paymentTerms.setDescription(paymentTermsDTO.getDescription());
        paymentTerms.setActiveFlag(paymentTermsDTO.getActiveFlag());

        paymentTerms = paymentTermsRepository.save(paymentTerms);
        return new PaymentTermsDTO(paymentTerms);
    }

    public PaymentTermsDTO getPaymentTermsById(Long id) {
        PaymentTerms paymentTerms = paymentTermsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment term not found"));
        return new PaymentTermsDTO(paymentTerms);
    }

    public List<PaymentTermsDTO> getAllPaymentTerms() {
        return paymentTermsRepository.findAll()
                .stream()
                .map(PaymentTermsDTO::new)
                .collect(Collectors.toList());
    }

    public PaymentTermsDTO updatePaymentTerms(Long id, PaymentTermsDTO paymentTermsDTO) {
        PaymentTerms paymentTerms = paymentTermsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment term not found"));

        paymentTerms.setTermName(paymentTermsDTO.getTermName());
        paymentTerms.setDescription(paymentTermsDTO.getDescription());
        paymentTerms.setActiveFlag(paymentTermsDTO.getActiveFlag());

        paymentTerms = paymentTermsRepository.save(paymentTerms);
        return new PaymentTermsDTO(paymentTerms);
    }

//    public void deletePaymentTerms(Long id) {
//        PaymentTerms paymentTerms = paymentTermsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Payment term not found"));
//        paymentTermsRepository.delete(paymentTerms);
//    }
    
    public void deletePaymentTerms(Long id) {
        // Check if category exists first
        if (!paymentTermsRepository.existsById(id)) {
            throw new EntityNotFoundException("Payment term not found with id: " + id);
        }
        
        try {
        	paymentTermsRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete Payment term because it is referenced by other");
        }
    }
}
