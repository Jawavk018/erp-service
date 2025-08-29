package com.tech3.erp.service;

import com.tech3.erp.dto.SubCategoryDTO;
import com.tech3.erp.entity.Category;
import com.tech3.erp.entity.SubCategory;
import com.tech3.erp.repository.CategoryRepository;
import com.tech3.erp.repository.SubCategoryRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public SubCategoryDTO createSubCategory(SubCategoryDTO subCategoryDTO) {
        Optional<Category> category = categoryRepository.findById(subCategoryDTO.getCategorySno());
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category not found");
        }

        SubCategory subCategory = new SubCategory();
        subCategory.setCategory(category.get());
        subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
        subCategory.setActiveFlag(subCategoryDTO.getActiveFlag());

        subCategory = subCategoryRepository.save(subCategory);
        return new SubCategoryDTO(subCategory);
    }

    public SubCategoryDTO getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sub-category not found"));
        return new SubCategoryDTO(subCategory);
    }

    public List<SubCategoryDTO> getAllSubCategories() {
        return subCategoryRepository.findAll()
                .stream()
                .map(SubCategoryDTO::new)
                .collect(Collectors.toList());
    }

    public SubCategoryDTO updateSubCategory(Long id, SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sub-category not found"));

        subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
        subCategory.setActiveFlag(subCategoryDTO.getActiveFlag());

        subCategory = subCategoryRepository.save(subCategory);
        return new SubCategoryDTO(subCategory);
    }

//    public void deleteSubCategory(Long id) {
//        SubCategory subCategory = subCategoryRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Sub-category not found"));
//        subCategoryRepository.delete(subCategory);
//    }
    
    public void deleteSubCategory(Long id) {
        // Check if category exists first
        if (!subCategoryRepository.existsById(id)) {
            throw new EntityNotFoundException("SubCategory not found with id: " + id);
        }
        
        try {
        	subCategoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete SubCategory because it is referenced by other");
        }
    }
    
    
    public List<SubCategoryDTO> getSubCategoriesByCategoryName(String categoryName) {
        List<SubCategory> subCategories = subCategoryRepository.findByCategoryCategoryName(categoryName);
        return subCategories.stream()
                .map(SubCategoryDTO::new)
                .collect(Collectors.toList());
    }

    
}
