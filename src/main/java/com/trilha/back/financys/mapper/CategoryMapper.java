package com.trilha.back.financys.mapper;


import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.modelmapper.ModelMapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "name", source="categoriaDTO.name")
    @Mapping(target = "description", source="categoriaDTO.description")
    public CategoriaEntity mapToCategoria(CategoriaDTO categoriaDTO);

    @Mapping(target = "name", source="categoriaEntity.name")
    @Mapping(target = "description", source="categoriaEntity.description")
    public CategoriaDTO mapToCategoriaDTO(CategoriaEntity categoriaEntity);

    ModelMapper mapper = new ModelMapper();
}
