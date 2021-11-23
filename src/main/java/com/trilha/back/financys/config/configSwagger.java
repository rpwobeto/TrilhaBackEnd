package com.trilha.back.financys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class configSwagger {

    @Bean
    public Docket financysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trilha.back.financys"))
                .paths(any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Desafio 4",
                "Testes com Swagger2",
                "1.0",
                "Terms of Service",
                new Contact("Ricardo Wobeto", "github.com/rpwobeto", "riwobeto@emeal.nttdata.com"),
                "Apache Lincense Version 2.0",
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}