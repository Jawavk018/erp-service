package com.tech3.erp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech3.erp.dto.EmptyBeamIssueDTO;
import com.tech3.erp.dto.EmptyBeamIssueItemDTO;
import com.tech3.erp.entity.EmptyBeamIssue;
import com.tech3.erp.entity.EmptyBeamIssueItem;
import com.tech3.erp.repository.EmptyBeamIssueRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmptyBeamIssueService {

    private final EmptyBeamIssueRepository emptyBeamIssueRepository;


    public EmptyBeamIssueService(EmptyBeamIssueRepository emptyBeamIssueRepository) {
        this.emptyBeamIssueRepository = emptyBeamIssueRepository;
    }

    @Transactional
    public EmptyBeamIssueDTO saveEmptyBeamIssue(EmptyBeamIssueDTO dto) {
    	EmptyBeamIssue order = mapDtoToEntity(dto, new EmptyBeamIssue());

        List<EmptyBeamIssueItem> items = mapItemDtosToEntities(dto.getItems(), order);
        order.setItems(items);

        EmptyBeamIssue savedOrder = emptyBeamIssueRepository.save(order);

        return mapEntityToDto(savedOrder);
    }

    public List<EmptyBeamIssueDTO> getAllEmptyBeamIssues() {
        List<EmptyBeamIssue> orders = emptyBeamIssueRepository.findAll();
        List<EmptyBeamIssueDTO> dtos = new ArrayList<>();
        for (EmptyBeamIssue order : orders) {
            dtos.add(mapEntityToDto(order));
        }
        return dtos;
    }

    public EmptyBeamIssueDTO getEmptyBeamIssueById(Long id) {
    	EmptyBeamIssue order = emptyBeamIssueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmptyBeamIssue not found with id: " + id));

        return mapEntityToDto(order);
    }

    @Transactional
    public EmptyBeamIssueDTO updateEmptyBeamIssue(Long id, EmptyBeamIssueDTO dto) {
    	EmptyBeamIssue existingOrder = emptyBeamIssueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmptyBeamIssue not found with id: " + id));

        mapDtoToEntity(dto, existingOrder);

        List<EmptyBeamIssueItem> updatedItems = mapItemDtosToEntities(dto.getItems(), existingOrder);
        existingOrder.getItems().clear();
        existingOrder.getItems().addAll(updatedItems);

        EmptyBeamIssue savedOrder = emptyBeamIssueRepository.save(existingOrder);
        return mapEntityToDto(savedOrder);
    }

    @Transactional
    public void deleteEmptyBeamIssue(Long id) {
    	EmptyBeamIssue order = emptyBeamIssueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EmptyBeamIssue not found with id: " + id));
        emptyBeamIssueRepository.delete(order);
    }

    // Helper: DTO to Entity Mapping
    private EmptyBeamIssue mapDtoToEntity(EmptyBeamIssueDTO dto, EmptyBeamIssue order) {
    	order.setEmptyBeamNo(dto.getEmptyBeamNo());
    	order.setEmptyBeamIssueDate(dto.getEmptyBeamIssueDate());
    	order.setConsigneeId(dto.getConsigneeId());
    	order.setVendorId(dto.getVendorId());
    	order.setVechileNo(dto.getVechileNo());
        return order;
    }

    private List<EmptyBeamIssueItem> mapItemDtosToEntities(List<EmptyBeamIssueItemDTO> itemDtos, EmptyBeamIssue order) {
        List<EmptyBeamIssueItem> items = new ArrayList<>();
        if (itemDtos != null) {
            for (EmptyBeamIssueItemDTO itemDto : itemDtos) {
            	EmptyBeamIssueItem item = new EmptyBeamIssueItem();
            	item.setEmptyBeamIssue(order);
                item.setFlangeId(itemDto.getFlangeId());
                items.add(item);
            }
        }
        return items;
    }

    // Helper: Entity to DTO Mapping
    private EmptyBeamIssueDTO mapEntityToDto(EmptyBeamIssue order) {
    	EmptyBeamIssueDTO dto = new EmptyBeamIssueDTO();
        dto.setId(order.getId());
        dto.setEmptyBeamNo(order.getEmptyBeamNo());
        dto.setEmptyBeamIssueDate(order.getEmptyBeamIssueDate());
        dto.setConsigneeId(order.getConsigneeId());
        dto.setVendorId(order.getVendorId());
        dto.setVechileNo(order.getVechileNo());

        List<EmptyBeamIssueItemDTO> itemDtos = new ArrayList<>();
        if (order.getItems() != null) {
            for (EmptyBeamIssueItem item : order.getItems()) {
            	EmptyBeamIssueItemDTO itemDto = new EmptyBeamIssueItemDTO();
//                itemDto.setId(item.getId());
            	itemDto.setFlangeId(item.getFlangeId());
                itemDtos.add(itemDto);
            }
        }
        dto.setItems(itemDtos);
        return dto;
    }
}

