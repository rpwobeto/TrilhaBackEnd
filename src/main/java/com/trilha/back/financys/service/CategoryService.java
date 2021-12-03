package com.trilha.back.financys.service;

import com.trilha.back.financys.DTO.CategoryDTO;
import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private List<CategoryDTO> CategoryListDTO = new ArrayList<>();

    private ModelMapper modelMapper;

    public Long idCategoryByName(String nameCategory ) {
        Category read = categoryRepository.findByName(nameCategory);
        return read.getId();
    }

    public void categoryByName (String categoryName){
        categoryRepository.findByName(categoryName);
    }

    public Category save(Category category){
        return categoryRepository.save(category);

    }

//        public CategoryService(CategoryRepository categoryRepository) {
//          this.categoryRepository = categoryRepository;
//      }

}