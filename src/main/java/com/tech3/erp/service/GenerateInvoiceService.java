package com.tech3.erp.service;

import com.tech3.erp.dto.GenerateInvoiceDTO;
import com.tech3.erp.entity.GenerateInvoice;
import com.tech3.erp.repository.GenerateInvoiceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenerateInvoiceService {

	@Autowired
    private final GenerateInvoiceRepository generateInvoiceRepository;
    
    public GenerateInvoiceService(GenerateInvoiceRepository generateInvoiceRepository) {
        this.generateInvoiceRepository = generateInvoiceRepository;
    }

    @Transactional
    public GenerateInvoiceDTO createInvoice(GenerateInvoiceDTO dto) {
        GenerateInvoice invoice = new GenerateInvoice();
        mapDtoToEntity(dto, invoice);
        GenerateInvoice savedInvoice = generateInvoiceRepository.save(invoice);
        return mapEntityToDto(savedInvoice);
    }

    public GenerateInvoiceDTO getInvoiceById(Long id) {
        GenerateInvoice invoice = generateInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        return mapEntityToDto(invoice);
    }

    public List<GenerateInvoiceDTO> getAllInvoices() {
        return generateInvoiceRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public GenerateInvoiceDTO updateInvoice(Long id, GenerateInvoiceDTO dto) {
        GenerateInvoice invoice = generateInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        mapDtoToEntity(dto, invoice);
        GenerateInvoice updatedInvoice = generateInvoiceRepository.save(invoice);
        return mapEntityToDto(updatedInvoice);
    }

    @Transactional
    public void deleteInvoice(Long id) {
        GenerateInvoice invoice = generateInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
        invoice.setActiveFlag(false);
        generateInvoiceRepository.save(invoice);
    }

    private GenerateInvoiceDTO mapEntityToDto(GenerateInvoice invoice) {
        GenerateInvoiceDTO dto = new GenerateInvoiceDTO();
        dto.setId(invoice.getId());
        dto.setManufactureId(invoice.getManufactureId());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setInvoiceNo(invoice.getInvoiceNo());
        dto.setSalesOrderId(invoice.getSalesOrderId());
        dto.setCompanyBankId(invoice.getCompanyBankId());
        dto.setTermsConditionsId(invoice.getTermsConditionsId());
        dto.setPaymentTermsId(invoice.getPaymentTermsId());
        dto.setShipToId(invoice.getShipToId());
        dto.setShipmentMode(invoice.getShipmentMode());
        dto.setCustomerId(invoice.getCustomerId());
        dto.setConsgineeId(invoice.getConsgineeId());
        dto.setTaxAmount(invoice.getTaxAmount());
        dto.setTotalAmount(invoice.getTotalAmount());
        dto.setComments(invoice.getComments());
        dto.setActiveFlag(invoice.getActiveFlag());
        return dto;
    }

    private void mapDtoToEntity(GenerateInvoiceDTO dto, GenerateInvoice invoice) {
        invoice.setManufactureId(dto.getManufactureId());
        invoice.setInvoiceDate(dto.getInvoiceDate());
        invoice.setInvoiceNo(dto.getInvoiceNo());
        invoice.setSalesOrderId(dto.getSalesOrderId());
        invoice.setCompanyBankId(dto.getCompanyBankId());
        invoice.setTermsConditionsId(dto.getTermsConditionsId());
        invoice.setPaymentTermsId(dto.getPaymentTermsId());
        invoice.setShipToId(dto.getShipToId());
        invoice.setShipmentMode(dto.getShipmentMode());
        invoice.setCustomerId(dto.getCustomerId());
        invoice.setConsgineeId(dto.getConsgineeId());
        invoice.setTaxAmount(dto.getTaxAmount());
        invoice.setTotalAmount(dto.getTotalAmount());
        invoice.setComments(dto.getComments());
        invoice.setActiveFlag(dto.getActiveFlag());
    }
}