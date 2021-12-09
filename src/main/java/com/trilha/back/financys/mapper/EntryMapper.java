package com.trilha.back.financys.mapper;

import com.trilha.back.financys.dto.EntryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import springfox.documentation.schema.Entry;

@Mapper(componentModel = "spring")
public interface EntryMapper {
    @Mapping(target = "name", source = "entryDTO.name")
    @Mapping(target = "description", source = "entryDTO.description" )
    @Mapping(target = "type", source = "entryDTO.type")
    @Mapping(target = "amount", source = "entryDTO.amount")
    @Mapping(target = "date", source = "entryDTO.date")
    @Mapping(target = "paid", source = "entryDTO.paid")
    public Entry mapToEntry(EntryDTO entryDTO);


    @Mapping(target = "name", source = "entry.name")
    @Mapping(target = "description", source = "entry.description" )
    @Mapping(target = "type", source = "entry.type")
    @Mapping(target = "amount", source = "entry.amount")
    @Mapping(target = "date", source = "entry.date")
    @Mapping(target = "paid", source = "entry.paid")
    public EntryDTO mapToEntry(Entry entry);
}


