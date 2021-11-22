package com.trilha.back.financys.controller;

import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;
import com.trilha.back.financys.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/financys")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(category));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> readAll(){
        List<Category> readAll = repository.findAll();
        return ResponseEntity.ok(readAll);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> read(@PathVariable Long id){
        Category read = repository.findById(id).get();
        return ResponseEntity.ok(read);
    }
    
    @PutMapping(value = "/category/{id}")
    public ResponseEntity<Category>
    update(@PathVariable(name = "id") Long id, @RequestBody Category category){
        category.setId(id);
        repository.save(category);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        repository.deleteById(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

}