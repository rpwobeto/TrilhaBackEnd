package com.trilha.back.financys.controllers;

import com.trilha.back.financys.dtos.ChartDTO;
import com.trilha.back.financys.dtos.LancamentosDTO;
import com.trilha.back.financys.entities.LancamentosEntity;
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
    public ResponseEntity<LancamentosEntity> save(@RequestBody LancamentosDTO lancamentosDTO) {
        return ResponseEntity.ok(lancamentosService.save(lancamentosDTO));
    }

    @GetMapping (value= "/get-all")
    @ApiOperation(value = "Retorna todos os lancamentos criados")
    public ResponseEntity<List<LancamentosEntity>> findAll() {
        List<LancamentosEntity> list= lancamentosService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/get-id/{id}")
    @ApiOperation(value = "Retorna o lancamento pelo ID")
    public LancamentosEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(lancamentosService.getById(id)).getBody();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody LancamentosDTO lancamentosDTO) {
        lancamentosService.updateById(id,lancamentosDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete-by/{id}")
    @ApiOperation(value = "Deleta o lancamento criado através do ID")
    public ResponseEntity<?> deleteLancamento(@PathVariable Long id) {
        lancamentosService.deleteLancamentos(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @GetMapping("/chartDTO")
//    public ResponseEntity<ChartDTO> grafico(){
//        return ResponseEntity.status(HttpStatus.OK).body(lancamentosService.grafico());
//    }


    @GetMapping(value = "/calcula/{x}/{y}")
    @ApiOperation(value = "Calcula a Média de X e Y")
    public Integer calculaMedia (@PathVariable("x") Integer x,
                                 @PathVariable("y") Integer y){
        return lancamentosService.calculaMedia(x, y);
    }
}
