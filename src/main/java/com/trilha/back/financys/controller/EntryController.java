package com.trilha.back.financys.controller;


import com.trilha.back.financys.entities.Entry;
import com.trilha.back.financys.repository.EntryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping (value = "/v4/financys/entry")
@Api(value = "API Financys")
@CrossOrigin(origins = "*")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping("/readAllEntry")
    @ApiOperation(value="Retorna toda a lista da Entry")
    public List<Entry> read(){
//        entryRepository.findAll().sort(Comparator.comparing(Entry::getDate));
        return (List<Entry>) entryRepository.findAll();
    }

    @GetMapping("/readEntry/{id}")
    @ApiOperation(value="Retorna um elemento da Entry pelo ID")
    public Optional<Entry> findEntryById(Long id){
//        entryRepository.findAll().sort(Comparator.comparing(Entry::getDate));
        return entryRepository.findById(id);
    }

    @PostMapping("/createEntry")
    @ApiOperation(value="Cria uma entry")
    public Entry create(@RequestBody Entry entry){
        System.out.println("A categoria foi encontrada");
        for (Entry value:
                entryRepository.findAll()) {
            if(value.getId() == entry.getId()){
                System.out.println( "Id: " +entry.getId() + " já pertence ao Banco de Dados");
                return entry;
            }
        }
        return entryRepository.save(entry);
    }

    @PutMapping("/putEntry/{id}")
    @ApiOperation(value="Atualiza um elemento da Entry de forma parcial")
    public ResponseEntity<Entry>
    update(@RequestBody Entry entry,
           @PathVariable("id") Long id) throws IllegalStateException{
        Entry entry1 = entryRepository.findById(id).orElseThrow(()
                -> new IllegalStateException(
                "A Entry com id: " + id + " não foi encontrada"
        ));
        entry1.setId(entry.getId());
        entry1.setName(entry.getName());
        entry1.setDescription(entry.getDescription());
        entry1.setAmount(entry.getAmount());
        entry1.setType(entry.getType());
        entry1.setDate(entry.getDate());
        entry1.isPaid(entry.getPaid());
        entry1.setCategoryId(entry.getCategoryId());
        entryRepository.save(entry1);
        return ResponseEntity.ok().body(entry1);
    }

    @DeleteMapping("/deleteEntry/{id}")
    @ApiOperation(value="Deleta uma Entry por ID")
    public void delete(Long id){
        entryRepository.deleteById(id);
    }

}