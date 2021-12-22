package com.trilha.back.financys.controllers;

import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.CategoriaEntity;
import com.trilha.back.financys.entities.LancamentosEntity;
import com.trilha.back.financys.repositories.LancamentosRepository;
import com.trilha.back.financys.services.CategoriaService;
import com.trilha.back.financys.services.LancamentosService;
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
@RequestMapping(value = "/financys/lancamentos")
@CrossOrigin(origins ="*")
@Api(value = "Desafios Trilha BackEnd Java - ENTRY")

public class LancamentosController {

    @Autowired
    private LancamentosService lancamentosService;

    @Autowired
    private CategoriaService categoriaService;



    @PostMapping(value = "/create")
    @ApiOperation(value = "Cria um Lancamento")
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentosEntity save (@RequestBody LancamentosEntity lancamentosEntity) {
        return lancamentosService.save(lancamentosEntity);
        //return ResponseEntity.ok().body(lancamentosService.save(lancamentosDTO)).getBody();
    }

    @GetMapping (value= "/get-all")
    @ApiOperation(value = "Retorna todos os lancamentos criados")
    @ResponseStatus(HttpStatus.OK)
    public List<LancamentosEntity> getAll() {
        return ResponseEntity.ok().body(lancamentosService.getAll()).getBody();
    }

    @GetMapping(value = "/get-id/{id}")
    @ApiOperation(value = "Retorna o lancamento pelo ID")
    public LancamentosEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(lancamentosService.getById(id)).getBody();
    }

    @PutMapping(path = "/update-by/{id}")
    @ApiOperation(value = "Atualiza o lançamento criado através do ID")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public LancamentosEntity  update(@PathVariable("id") Long id, @RequestBody LancamentosDTO lancamentosDTO) {

      return  ResponseEntity.ok().body(lancamentosService.update(id,lancamentosDTO)).getBody();
    }

    @DeleteMapping(path = "/delete-by/{id}")
    @ApiOperation(value = "Deleta o lancamento criado através do ID")
    public ResponseEntity<?> deleteLancamento(@PathVariable Long id) {
        lancamentosService.deleteLancamentos(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping(value = "/create")
//    @ApiOperation(value = "Cria uma CategoriaEntity")
//    public CategoriaEntity save(@RequestBody CategoriaDTO categoriaDTO) {
//        return ResponseEntity.ok().body(categoryService.save(categoriaDTO)).getBody();
//    }

//    @GetMapping(value = "/getAll")
//    @ApiOperation(value = "Retorna todas as entries criadas")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<LancamentosEntity> getAll (@RequestBody @Valid LancamentosEntity lancamentos){
//        return lancamentosRepository.findAll(lancamentos);
//    }
//
//    @GetMapping(value = "/read-by/{id}")
//    @ApiOperation(value = "Retorna a entry pelo ID")
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<LancamentosEntity> getById(@PathVariable Long id){
//        lancamentosService.getById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping(value = "/update-by/{id}")
//    @ApiOperation(value = "Atualiza a lancamentos criada através do ID")
//    public ResponseEntity<LancamentosEntity> update(@PathVariable(name = "id") Long id, @RequestBody LancamentosEntity lancamentos){
//        lancamentos.setId(id);
//        lancamentosService.save(lancamentos);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @DeleteMapping("/delete-by/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ApiOperation(value = "Deleta a entry criada através do ID")
//    public ResponseEntity<LancamentosEntity> deleteEntry(@PathVariable Long id){
//        return  ResponseEntity.ok().build();
//    }
//
//    @GetMapping(value = "/calcula/{x}/{y}")
//    @ApiOperation(value = "Calcula a Média de X e Y")
//    public Integer calculaMedia (@PathVariable("x") Integer x,
//                                 @PathVariable("y") Integer y){
//        return lancamentosService.calculatesAverage(x, y);
//    }

}

//    @GetMapping(value = "/read-dto")
//    @ApiOperation(value = "Retorna as Entries do DTO")
//    public List<LancamentosDTO> readDTO(){
//        return entryService.returnListDTO();
//    }
//    @GetMapping(value = "/find-by-categoria-name")
//    @ApiOperation(value = "Retorna um ID da CategoriaEntity pelo nome")
//    @ResponseStatus(HttpStatus.FOUND)
//    public ResponseEntity<?> findByName (@PathVariable String categoryName){
//        Long category = categoryService.idCategoryByName(categoryName);
//        return ResponseEntity.ok(category);
//    }
