package com.trilha.back.financys.service;

import com.trilha.back.financys.DTO.EntryDTO;
import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.CategoryRepository;
import com.trilha.back.financys.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EntryService {

    private final EntryRepository entryRepository;

    private final CategoryRepository categoryRepository;

    private final ModelMapper mapper;

    private List<EntryDTO> entryDTOList = new ArrayList<>();

    public boolean validadeCategoryByIdL(long idCategory){
        Optional<Category> category = categoryRepository.findById(idCategory);
        return category.isPresent();
    }

    public Entry create (Entry entry){
        boolean categoryExists = validadeCategoryByIdL(entry.getCategory().getId());
        if(categoryExists == false){
            System.out.println("A Category não foi encontrada");
        }
        return entryRepository.save(entry);
    }

    private EntryDTO mapToDto(Entry entry){
        EntryDTO entryDTO = mapper.map(entry, EntryDTO.class);
        return entryDTO;
    }

    private Entry mapToEntity(EntryDTO entryDTO){
        Entry entry = mapper.map(entryDTO, Entry.class);
        return entry;
    }

    public List<EntryDTO> returnListDTO(){
        List<Entry> entryList = entryRepository.findAll();
        entryRepository.getClass();
        return entryList.stream().map(this::mapToDto).collect(Collectors.toList());
    }
//
//    public List<EntryDTO> returnListDTO() {
//        List<Entry> listEntry = entryRepository.findAll();
//        for (Entry entryCategory : listEntry){
//            entryCategory.getCategory();
//        }
//        return listEntry.stream().map(this::mapToDto).collect(Collectors.toList());
//    }

}