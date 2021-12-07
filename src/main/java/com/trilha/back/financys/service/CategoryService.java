package com.trilha.back.financys.service;

import com.trilha.back.financys.DTO.CategoryDTO;


public interface CategoryService{

    Long idCategoryByName(String nameCategory);

    void categoryByName (String categoryName);

    void save(CategoryDTO categoryDTO);
}