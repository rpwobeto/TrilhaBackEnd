package com.trilha.back.financys.controller;


import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping("/category")
    public Long create(@RequestBody Category category){

        return categoryRepository.save(category).getId();

    }

    @GetMapping("/category")
    public List<Category> read(){

        return categoryRepository.findAll();

    }

    @GetMapping("/category/{id}")
    public Optional<Category> findCategoryById(Long id){

        System.out.println("A categoria foi encontrada");
        return categoryRepository.findById(id);

    }

    @PutMapping("/category/")
    public ResponseEntity<Category>
    update(@RequestBody Category category,
           @PathVariable("id") Long id) throws IllegalStateException{

        Category category1 = categoryRepository.findById(id).orElseThrow(()
                -> new IllegalStateException(
                "A categoria do ID: " + id + " não foi encontrada"
        ));

        category1.setId(category.getId());
        category1.setName(category.getName());
        category1.setDescription(category.getDescription());
        categoryRepository.save(category1);
        return ResponseEntity.ok().body(category1);

    }

    @DeleteMapping("/category/{id}")
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

}