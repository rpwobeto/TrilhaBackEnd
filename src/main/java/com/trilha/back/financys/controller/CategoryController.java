package com.trilha.back.financys.controller;


import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;
import com.trilha.back.financys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        CategoryService categoryService = new CategoryService();

        if(categoryService.validateCategoryById(categoryRepository, category)){
            System.out.println( "O Id: " + category.getId() + " já existe no Banco de Dados");
            return -1L;
        } else

        System.out.println( "Uma nova categoria foi criada. ID: " + category.getId());
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

    @PutMapping(value = "/category/{id}")
    public ResponseEntity<Category> update(@PathVariable(name = "id") Long id, @RequestBody Category category){
        category.setId(id);
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){

        categoryRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}