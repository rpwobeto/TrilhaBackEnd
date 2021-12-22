package com.trilha.back.financys.mapper;

import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.LancamentosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.modelmapper.ModelMapper;


@Mapper(componentModel = "spring")
public interface LancamentosMapper {

    @Mapping(target = "name", source="lancamentosDTO.name")
    @Mapping(target = "description", source="lancamentosDTO.description")
    @Mapping(target = "type", source="lancamentosDTO.type")
    @Mapping(target = "amount", source="lancamentosDTO.amount")
    @Mapping(target = "date", source="lancamentosDTO.date")
    @Mapping(target = "paid", source="lancamentosDTO.paid")
    public LancamentosEntity mapToLancamentos(LancamentosDTO lancamentosDTO);

    @Mapping(target = "name", source="lancamentosEntity.name")
    @Mapping(target = "description", source="lancamentosEntity.description")
    @Mapping(target = "type", source="lancamentosEntity.type")
    @Mapping(target = "amount", source="lancamentosEntity.amount")
    @Mapping(target = "date", source="lancamentosEntity.date")
    @Mapping(target = "paid", source="lancamentosEntity.paid")
    public LancamentosDTO mapLancamentosDTO(LancamentosEntity lancamentosEntity);

    ModelMapper mapper = new ModelMapper();
}
