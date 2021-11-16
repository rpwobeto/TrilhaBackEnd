package com.trilha.back.financys.service;

import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.EntryRepository;

public class EntryService {
    public boolean validateEntryById(EntryRepository entryRepository, Entry entry){

        for (Entry value : entryRepository.findAll()) {
            if(value.getId() == entry.getId()){
                return true;
            }
        }
        return false;
    }

}
