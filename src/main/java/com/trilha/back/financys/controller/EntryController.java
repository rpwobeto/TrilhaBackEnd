package com.trilha.back.financys.controller;

import com.trilha.back.financys.entities.Entry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/entry")
@Api(value = "Desafio 3")
@CrossOrigin(origins = "*")

public class EntryController {

    private final List<Entry> list = new ArrayList<Entry>();

    @PostMapping(" ")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create Entry")

    public int create(@RequestBody Entry entry){
        list.add(entry);
        return list.indexOf(entry);
    }

    @GetMapping(" ")
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation(value = "Order Date List Entry")
    public List<Entry> read (){

        sortDates(list);
        return list;
    }

    private static void sortDates(List<Entry> list) {
        list.sort(Comparator.comparing(Entry::getDate));
    }
}
