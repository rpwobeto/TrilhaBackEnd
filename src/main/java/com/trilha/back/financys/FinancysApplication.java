package com.trilha.back.financys;

import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.entities.Entry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class FinancysApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinancysApplication.class, args);

	}


}
