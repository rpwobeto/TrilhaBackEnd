package com.trilha.back.financys.service;

import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;

public class CategoryService {
    public boolean validateCategoryById(CategoryRepository categoryRepository, Category category){
        for (Category value : categoryRepository.findAll()) {
            if(value.getId() == category.getId()){
                return true;
            }
        }
        return false;
    }
}
