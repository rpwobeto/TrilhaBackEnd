package com.trilha.back.financys.controllers;

import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.services.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categorias")
@Api(value = "Desafios Trilha BackEnd Java - CATEGORIA")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoryService;

    @PostMapping
    @ApiOperation(value = "Cria uma CategoriaEntity")
    public CategoriaEntity save(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(categoryService.save(categoriaDTO)).getBody();
    }

    @GetMapping
    @ApiOperation(value = "Retorna todas as categorias criadas")
    public ResponseEntity<List<CategoriaEntity>> findAll() {
        List<CategoriaEntity> list= categoryService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna a categoria pelo ID")
    public CategoriaEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(categoryService.getById(id)).getBody();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoriaDTO categoryDTO) {
        categoryService.updateById(id,categoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta a categoria criada através do ID")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}