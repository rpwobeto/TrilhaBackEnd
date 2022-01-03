package com.trilha.back.financys.controllers;

import com.trilha.back.financys.dtos.CategoriaDTO;
import com.trilha.back.financys.dtos.LancamentosDTO;
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
@RequestMapping(value = "/financys/categoria")
@Api(value = "Desafios Trilha BackEnd Java - CATEGORIA")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoryService;


    @PostMapping(value = "/create")
    @ApiOperation(value = "Cria uma CategoriaEntity")
    public CategoriaEntity save(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(categoryService.save(categoriaDTO)).getBody();
    }

    @GetMapping(path = "/get-all")
    @ApiOperation(value = "Retorna todas as categorias criadas")
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

//    @GetMapping (value= "/get-all")
//    @ApiOperation(value = "Retorna todas as categorias criadas")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CategoriaEntity> getAll(CategoriaDTO dto ) {
//        return ResponseEntity.ok().body(categoryService.getAll(dto)).getBody();
//    }

    @GetMapping(value = "/getId/{id}")
    @ApiOperation(value = "Retorna a categoria pelo ID")
    public CategoriaEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(categoryService.getById(id)).getBody();
    }

    @PutMapping(path = "/update-by/{id}")
    @ApiOperation(value = "Atualiza a categoria criada através do ID")
    //@ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @RequestBody CategoriaDTO dto) {
        categoryService.update(id);
      return  ResponseEntity.ok().body(categoryService.save(dto));
    }

    @DeleteMapping(path = "/delete-by/{id}")
    @ApiOperation(value = "Deleta a categoria criada através do ID")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}