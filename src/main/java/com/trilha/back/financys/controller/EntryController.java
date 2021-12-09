package com.trilha.back.financys.controller;

import com.trilha.back.financys.dto.EntryDTO;
import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.EntryRepository;
import com.trilha.back.financys.service.CategoryService;
import com.trilha.back.financys.service.EntryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v6/financys/entry")
@CrossOrigin(origins ="*")
@Api(value = "Desafios Trilha BackEnd Java - ENTRY")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EntryRepository entryRepository;


    @PostMapping(value = "/create")
    @ApiOperation(value = "Cria uma Entry")
    public ResponseEntity<Entry> create (@RequestBody @Valid Entry entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Entry.builder().build());//entryDTO.create(entry));
    }
//    public ResponseEntity<Entry> create (@RequestBody  Entry entry) {
//        return ResponseEntity.status(HttpStatus.CREATED).build().getBody(entryService.create());   //build() //body(entryService.create());
//    }

    @GetMapping(value = "/read-all")
    @ApiOperation(value = "Retorna todas as entries criadas")
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
    @ApiOperation(value = "Retorna a entry pelo ID")
    public ResponseEntity<Entry> read(@PathVariable Long id){
        Entry read = entryRepository.findById(id).get();
        return ResponseEntity.ok(read);
    }

    @GetMapping(value = "/entry/find-by-category-name")
    @ApiOperation(value = "Retorna um ID da Categoria pelo nome")
    public ResponseEntity<?> findByName (@PathVariable String categoryName){
        Long category = categoryService.idCategoryByName(categoryName);
        return ResponseEntity.ok(category);
    }

    @GetMapping(value = "/read-dto")
    @ApiOperation(value = "Retorna as Entries do DTO")
    public List<EntryDTO> readDTO(){
        return entryService.returnListDTO();
    }

    @PutMapping(value = "/update-by/{id}")
    @ApiOperation(value = "Atualiza a entry criada através do ID")
    public ResponseEntity<Entry>
    update(@PathVariable(name = "id") Long id, @RequestBody Entry entry){
        entry.setId(id);
        entryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete-by/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleta a entry criada através do ID")
    public ResponseEntity<?> deleteEntry(@PathVariable Long id){
        entryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}