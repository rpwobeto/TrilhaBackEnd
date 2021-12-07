package com.trilha.back.financys.mapper;

import com.trilha.back.financys.DTO.CategoryDTO;
import com.trilha.back.financys.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "name", source = "categoryDTO.name" )
    @Mapping(target = "description", source = "categoryDTO.description" )
    public Category mapToCategory(CategoryDTO categoryDTO);

    @Mapping(target = "name", source = "category.name" )
    @Mapping(target = "description", source = "category.description" )
    public CategoryDTO mapToDTO(Category category);
}


