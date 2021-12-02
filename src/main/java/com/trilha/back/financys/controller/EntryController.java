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
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v6/financys/entry")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private EntryService entryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/create")
    public ResponseEntity<Entry> create (@RequestBody Entry entry) {
        return new ResponseEntity<Entry>(entryService.create(entry),HttpStatus.CREATED);
    }

    @GetMapping(value = "/read-all")
    public ResponseEntity<List<Entry>>
    findAll (@RequestParam (value = "paid", required = false) Boolean paid){
        List<Entry> entry;
        if (Objects.isNull(paid)){
            entry = entryRepository.findAll();
        }else{
            entry = entryRepository.findByPaid(paid);
        }
        return ResponseEntity.ok(entry);
    }

    @GetMapping(value = "/read-by/{id}")

    public ResponseEntity<Entry> read(@PathVariable Long id){
        Entry read = entryRepository.findById(id).get();
        return ResponseEntity.ok(read);
    }

    @GetMapping(value = "/find-by-name-category-name")
    public ResponseEntity<Long> findByName (@PathVariable String categoryName){
        return new ResponseEntity<Long>(categoryService.idCategoryByName(categoryName), HttpStatus.OK);
    }

    @GetMapping(value = "/read-dto")
    public List<EntryDTO> readDTO(){
        return entryService.returnListDTO();
    }

    @PutMapping(value = "/update-by/{id}")
    public ResponseEntity<Entry>
    update(@PathVariable(name = "id") Long id, @RequestBody Entry entry){
        entry.setId(id);
        entryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete-by/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteEntry(@PathVariable Long id){
        entryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}