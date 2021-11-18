package com.trilha.back.financys.controller;


import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.CategoryRepository;
import com.trilha.back.financys.repository.EntryRepository;
import com.trilha.back.financys.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;
    private CategoryRepository categoryRepository;

    @PostMapping("/entry")
    public Long create(@RequestBody Entry entry){
        EntryService entryService = new EntryService();

        if(entryService.validateEntryById(entryRepository, entry)){
            System.out.println( "O Id: " + entry.getId() + " já existe no Banco de Dados");
            return -1L;
        }else
            System.out.println( "Uma nova Entrada foi criada. ID: " + entry.getName());
        return entryRepository.save(entry).getId();
    }

    @GetMapping("/entry")
    public List<Entry> read(){

        entryRepository.findAll().sort(Comparator.comparing(Entry::getDate));
        return entryRepository.findAll();

    }

    @GetMapping("/entry/{id}")
    public Optional<Entry> findEntryById(Long id){
        entryRepository.findAll().sort(Comparator.comparing(Entry::getDate));
        return entryRepository.findById(id);
    }

    @PutMapping(value = "/entry/{id}")
    public ResponseEntity<Entry> update(@PathVariable(name = "id") Long id, @RequestBody Entry entry){
        entry.setId(id);
        entryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/entry/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){

        entryRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}