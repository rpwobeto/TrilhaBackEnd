package com.trilha.back.financys.controller;

import com.trilha.back.financys.entities.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Api(value = "Desafio 3")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")

public class CategoryController {

        private List<Category> list = new ArrayList<Category>();

        @PostMapping(" ")
        @ResponseStatus(HttpStatus.CREATED)
        @ApiOperation(value = "Create Category List")
        public int create(@RequestBody Category category) {
            list.add(category);
            return list.indexOf(category);
    }

        @GetMapping (" ")
        @ResponseStatus(HttpStatus.CREATED)
        @ApiOperation(value = "Return Created Category List")

        public List<Category> read (){

        return list;
    }
}
