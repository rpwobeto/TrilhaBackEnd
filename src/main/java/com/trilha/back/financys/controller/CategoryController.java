package com.trilha.back.financys.controller;

import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;
import com.trilha.back.financys.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v6/financys/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/create")
    @ApiOperation(value = "Cria uma Categoria")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(category));
    }

    @GetMapping(value = "/read-all")
    @ApiOperation(value = "Lê todas as categorias criadas")
    public ResponseEntity<List<Category>> readAll(){
        List<Category> readAll = repository.findAll();
        return ResponseEntity.ok(readAll);
    }

    @GetMapping(value = "/read-by/{id}")
    @ApiOperation(value = "Lê todas as categorias por ID")
    public ResponseEntity<Category> read(@PathVariable Long id){
        Category read = repository.findById(id).get();
        return ResponseEntity.ok(read);
    }
    
    @PutMapping(value = "/update-by/{id}")
    @ApiOperation(value = "Atualiza a categoria criada através do ID")
    public ResponseEntity<Category>
    update(@PathVariable(name = "id") Long id, @RequestBody Category category){
        category.setId(id);
        repository.save(category);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete-by/{id}")
    @ApiOperation(value = "Deleta a categoria criada através do ID")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        repository.deleteById(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

}