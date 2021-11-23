package com.trilha.back.financys.controller;

import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.repository.CategoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping (value = "/v4/financys/category")
@Api(value = "API Financys")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/readAllCategory")
    @ApiOperation(value="Retorna toda a lista da Category")
    public List<Category> read(){
        return categoryRepository.findAll();
    }

    @GetMapping("/readCategory/{id}")
    @ApiOperation(value="Retorna um elemento da Category pelo ID")
    public Optional<Category> findCategoryById(Long id){
        System.out.println("A categoria foi encontrada");
        return categoryRepository.findById(id);
    }

    @PostMapping("/createCategory")
    @ApiOperation(value="Cria uma categoria")
    public Category create(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @PutMapping("/putCategory")
    @ApiOperation(value="Atualiza um elemento da Category de forma parcial")
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

    @DeleteMapping("/deleteCategory/{id}")
    @ApiOperation(value="Deleta um categoria por ID")
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}