package com.tech3.erp.service;

import com.tech3.erp.dto.CategoryDTO;
import com.tech3.erp.entity.Category;
import com.tech3.erp.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setActiveFlag(categoryDTO.getActiveFlag());

        return new CategoryDTO(categoryRepository.save(category));
    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return new CategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        category.setCategoryName(categoryDTO.getCategoryName());
        category.setActiveFlag(categoryDTO.getActiveFlag());

        return new CategoryDTO(categoryRepository.save(category));
    }
    
//    public void deleteCategory(Long id) {
//        if (!categoryRepository.existsById(id)) {
//            throw new IllegalArgumentException("Category not found");
//        }
//        categoryRepository.deleteById(id);
//    }
    
    public void deleteCategory(Long id) {
        // Check if category exists first
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
        
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("Cannot delete category because it is referenced by other entities");
        }
    }
    
}
