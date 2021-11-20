package com.trilha.back.financys.controller;

import com.trilha.back.financys.DTO.EntryDTO;
import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.EntryRepository;
import com.trilha.back.financys.service.CategoryService;
import com.trilha.back.financys.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.trilha.back.financys.DTO.LancamentosDTO;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/financys")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private EntryService entryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/entry")
    public ResponseEntity<?> create (@RequestBody Entry entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entryService.create(entry));
    }

    @GetMapping("/entry")
    public ResponseEntity<List<Entry>>
    findAll (@RequestParam (value = "paid", required = false)Boolean paid){
        List<Entry> entry = new ArrayList<>();
        if (Objects.isNull(paid)){
            entry = entryRepository.findAll();
        }else{
            entry = entryRepository.findByPaid(paid);
        }
        return ResponseEntity.ok(entry);
    }

    @GetMapping("/entry/{id}")

    public ResponseEntity<Entry> read(@PathVariable Long id){
        Entry read = entryRepository.findById(id).get();
        return ResponseEntity.ok(read);
    }

    @GetMapping(value = "/entry/category/{categoryName}")
    public ResponseEntity<?> findByName (@PathVariable String categoryName){
        Long category = categoryService.idCategoryByName(categoryName);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/entry/category")
    public List<EntryDTO> readDTO(){
        return entryService.returnListDTO();
    }

    @PutMapping(value = "/entry/{id}")
    public ResponseEntity<Entry>
    update(@PathVariable(name = "id") Long id, @RequestBody Entry entry){
        entry.setId(id);
        entryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/entry/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteEntry(@PathVariable Long id){
        entryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}