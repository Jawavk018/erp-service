package com.tech3.erp.service;

import com.tech3.erp.dto.ProductCategoryDTO;
import com.tech3.erp.entity.PoTypeMaster;
import com.tech3.erp.entity.ProductCategory;
import com.tech3.erp.repository.PoTypeMasterRepository;
import com.tech3.erp.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository repository;
    private final PoTypeMasterRepository poTypeRepository;

    public ProductCategoryService(ProductCategoryRepository repository, PoTypeMasterRepository poTypeRepository) {
        this.repository = repository;
        this.poTypeRepository = poTypeRepository;
    }

    public ProductCategoryDTO createProductCategory(ProductCategoryDTO dto) {
        PoTypeMaster poType = poTypeRepository.findById(dto.getPoTypeId().longValue())
                .orElseThrow(() -> new IllegalArgumentException("Invalid PO Type ID"));

        ProductCategory category = new ProductCategory();
        category.setPoType(poType);
        category.setProductCategoryName(dto.getProductCategoryName());
        category.setFabricCode(dto.getFabricCode());
        category.setFabricQuality(dto.getFabricQuality());
        category.setActiveFlag(dto.getActiveFlag());

        return new ProductCategoryDTO(repository.save(category));
    }

    public ProductCategoryDTO getProductCategoryById(Long id) {
        return repository.findById(id)
                .map(ProductCategoryDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Product Category not found"));
    }

    public List<ProductCategoryDTO> getAllProductCategory() {
        return repository.findAll().stream()
                .map(ProductCategoryDTO::new)
                .collect(Collectors.toList());
    }

    public ProductCategoryDTO updateProductCategory(Long id, ProductCategoryDTO dto) {
        ProductCategory category = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product Category not found"));

        PoTypeMaster poType = poTypeRepository.findById(dto.getPoTypeId().longValue())
                .orElseThrow(() -> new IllegalArgumentException("Invalid PO Type ID"));

        category.setPoType(poType);
        category.setProductCategoryName(dto.getProductCategoryName());
        category.setFabricCode(dto.getFabricCode());
        category.setFabricQuality(dto.getFabricQuality());
        category.setActiveFlag(dto.getActiveFlag());

        return new ProductCategoryDTO(repository.save(category));
    }

    public void deleteProductCategory(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Product Category not found");
        }
        repository.deleteById(id);
    }
}

