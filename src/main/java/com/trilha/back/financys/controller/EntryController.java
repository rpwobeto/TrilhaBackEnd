package com.trilha.back.financys.controller;


import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.EntryRepository;
import com.trilha.back.financys.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @PostMapping("/entry")
    public Long create(@RequestBody Entry entry){
        EntryService entryService = new EntryService();

        if(entryService.validateEntryById(entryRepository, entry)){
            System.out.println( "O Id: " + entry.getId() + " já existe no Banco de Dados");
            return -1L;
        }

        System.out.println( "Uma nova categoria foi criada. ID: " + entry.getId());
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

    @PutMapping("/entry/{id}")
    public ResponseEntity<Entry>
    update(@RequestBody Entry entry,
           @PathVariable("id") Long id) throws IllegalStateException{
        Entry entry1 = entryRepository.findById(id).orElseThrow(()
                -> new IllegalStateException(
                "A Entry com id: " + id + " não foi encontrada"
        ));
        entry1.setId(entry.getId());
        entry1.setName(entry.getName());
        entry1.setDescription(entry.getDescription());
        entry1.setAmount(entry.getAmount());
        entry1.setType(entry.getType());
        entry1.setDate(entry.getDate());
        entry1.isPaid(entry.getPaid());
        entry1.setCategoryId(entry.getCategoryId());
        entryRepository.save(entry1);
        return ResponseEntity.ok().body(entry1);
    }

    @DeleteMapping("/entry/{id}")
    public void delete(Long id){
        entryRepository.deleteById(id);
    }

}