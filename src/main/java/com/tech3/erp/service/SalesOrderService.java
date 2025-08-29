package com.tech3.erp.service;

import com.tech3.erp.dto.SalesOrderDTO;
import com.tech3.erp.dto.SalesOrderItemDTO;
import com.tech3.erp.entity.SalesOrder;
import com.tech3.erp.entity.SalesOrderItem;
import com.tech3.erp.repository.CustomerRepository;
import com.tech3.erp.repository.SalesOrderRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesOrderService {

    private final SalesOrderRepository salesOrderRepository;
    private final CustomerRepository customerRepository;


    public SalesOrderService(SalesOrderRepository salesOrderRepository, CustomerRepository customerRepository) {
        this.salesOrderRepository = salesOrderRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public SalesOrderDTO saveSalesOrder(SalesOrderDTO dto) {
        SalesOrder order = mapDtoToEntity(dto, new SalesOrder());

        List<SalesOrderItem> items = mapItemDtosToEntities(dto.getItems(), order);
        order.setItems(items);

        SalesOrder savedOrder = salesOrderRepository.save(order);

        return mapEntityToDto(savedOrder);
    }

    public List<SalesOrderDTO> getAllSalesOrders() {
        List<SalesOrder> orders = salesOrderRepository.findAll();
        List<SalesOrderDTO> dtos = new ArrayList<>();
        for (SalesOrder order : orders) {
            dtos.add(mapEntityToDto(order));
        }
        return dtos;
    }

    public SalesOrderDTO getSalesOrderById(Long id) {
        SalesOrder order = salesOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SalesOrder not found with id: " + id));

        return mapEntityToDto(order);
    }

    @Transactional
    public SalesOrderDTO updateSalesOrder(Long id, SalesOrderDTO dto) {
        SalesOrder existingOrder = salesOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SalesOrder not found with id: " + id));

        mapDtoToEntity(dto, existingOrder);

        List<SalesOrderItem> updatedItems = mapItemDtosToEntities(dto.getItems(), existingOrder);
        existingOrder.getItems().clear();
        existingOrder.getItems().addAll(updatedItems);

        SalesOrder savedOrder = salesOrderRepository.save(existingOrder);
        return mapEntityToDto(savedOrder);
    }

    @Transactional
//    public void deleteSalesOrder(Long id) {
//        SalesOrder order = salesOrderRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("SalesOrder not found with id: " + id));
//        salesOrderRepository.delete(order);
//    }
    
    public void deleteSalesOrder(Long id) {
        // Check if category exists first
        if (!salesOrderRepository.existsById(id)) {
            throw new EntityNotFoundException("SalesOrder not found with id: " + id);
        }
        
        try {
        	salesOrderRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete SalesOrder because it is referenced by other");
        }
    }

    // Helper: DTO to Entity Mapping
    private SalesOrder mapDtoToEntity(SalesOrderDTO dto, SalesOrder order) {
    	order.setSalesOrderNo(dto.getSalesOrderNo());
        order.setOrderDate(dto.getOrderDate());
        order.setBuyerCustomerId(dto.getBuyerCustomerId());
        order.setBuyerPoNo(dto.getBuyerPoNo());
        order.setDeliverToId(dto.getDeliverToId());
        order.setCurrencyId(dto.getCurrencyId());
        order.setExchangeRate(dto.getExchangeRate());
        order.setModeOfShipmentId(dto.getModeOfShipmentId());
        order.setShipmentTermsId(dto.getShipmentTermsId());
        order.setPaymentTermsId(dto.getPaymentTermsId());
        order.setTermsConditionsId(dto.getTermsConditionsId());
        order.setActiveFlag(dto.getActiveFlag());
        order.setInternalOrderNo(dto.getInternalOrderNo());
        order.setPackingTypeId(dto.getPackingTypeId());
        return order;
    }

    private List<SalesOrderItem> mapItemDtosToEntities(List<SalesOrderItemDTO> itemDtos, SalesOrder order) {
        List<SalesOrderItem> items = new ArrayList<>();
        if (itemDtos != null) {
            for (SalesOrderItemDTO itemDto : itemDtos) {
                SalesOrderItem item = new SalesOrderItem();
                item.setSalesOrder(order);
                item.setFabricTypeId(itemDto.getFabricTypeId());
                item.setQuality(itemDto.getQuality());
                item.setBuyerProduct(itemDto.getBuyerProduct());
                item.setOrderQty(itemDto.getOrderQty());
                item.setPricePerUnit(itemDto.getPricePerUnit());
                item.setUomId(itemDto.getUomId());
                item.setTotalAmount(itemDto.getTotalAmount());
                item.setGstPercent(itemDto.getGstPercent());
                item.setGstAmount(itemDto.getGstAmount());
                item.setFinalAmount(itemDto.getFinalAmount());
                item.setDeliveryDate(itemDto.getDeliveryDate());
                item.setRemarks(itemDto.getRemarks());
                item.setFabricMasterTypeId(itemDto.getFabricMasterTypeId());
                item.setFabricCategoryId(itemDto.getFabricCategoryId());
                item.setFabricMasterId(itemDto.getFabricMasterId());
                item.setActiveFlag(itemDto.getActiveFlag());
                items.add(item);
            }
        }
        return items;
    }

    // Helper: Entity to DTO Mapping
    private SalesOrderDTO mapEntityToDto(SalesOrder order) {
        SalesOrderDTO dto = new SalesOrderDTO();
        dto.setId(order.getId());
        dto.setSalesOrderNo(order.getSalesOrderNo());
        dto.setOrderDate(order.getOrderDate());
        dto.setBuyerCustomerId(order.getBuyerCustomerId());
        dto.setBuyerPoNo(order.getBuyerPoNo());
        dto.setDeliverToId(order.getDeliverToId());
        dto.setCurrencyId(order.getCurrencyId());
        dto.setExchangeRate(order.getExchangeRate());
        dto.setModeOfShipmentId(order.getModeOfShipmentId());
        dto.setShipmentTermsId(order.getShipmentTermsId());
        dto.setPaymentTermsId(order.getPaymentTermsId());
        dto.setTermsConditionsId(order.getTermsConditionsId());
        dto.setActiveFlag(order.getActiveFlag());
        dto.setInternalOrderNo(order.getInternalOrderNo());
        dto.setPackingTypeId(order.getPackingTypeId());

        customerRepository.findById(order.getBuyerCustomerId())
        .ifPresent(customer -> dto.setBuyerCustomerName(customer.getCustomerName()));
        
        List<SalesOrderItemDTO> itemDtos = new ArrayList<>();
        if (order.getItems() != null) {
            for (SalesOrderItem item : order.getItems()) {
                SalesOrderItemDTO itemDto = new SalesOrderItemDTO();
//                itemDto.setId(item.getId());
                itemDto.setFabricTypeId(item.getFabricTypeId());
                itemDto.setQuality(item.getQuality());
                itemDto.setBuyerProduct(item.getBuyerProduct());
                itemDto.setOrderQty(item.getOrderQty());
                itemDto.setPricePerUnit(item.getPricePerUnit());
                itemDto.setUomId(item.getUomId());
                itemDto.setTotalAmount(item.getTotalAmount());
                itemDto.setGstPercent(item.getGstPercent());
                itemDto.setGstAmount(item.getGstAmount());
                itemDto.setFinalAmount(item.getFinalAmount());
                itemDto.setDeliveryDate(item.getDeliveryDate());
                itemDto.setRemarks(item.getRemarks());
                itemDto.setFabricMasterTypeId(item.getFabricMasterTypeId());
                itemDto.setFabricCategoryId(item.getFabricCategoryId());
                itemDto.setFabricMasterId(item.getFabricMasterId());
                itemDto.setActiveFlag(item.getActiveFlag());
                itemDtos.add(itemDto);
            }
        }
        dto.setItems(itemDtos);
        return dto;
    }
    
 // Add this method to your existing service
    public List<SalesOrderDTO> getSalesOrdersByCustomerId(Long customerId) {
        List<SalesOrder> orders = salesOrderRepository.findByBuyerCustomerId(customerId);
        List<SalesOrderDTO> dtos = new ArrayList<>();
        
        for (SalesOrder order : orders) {
            dtos.add(mapEntityToDto(order));
        }
        
        return dtos;
    }
}

