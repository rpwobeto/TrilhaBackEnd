package com.trilha.back.financys.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trilha.back.financys.entities.CategoriaEntity;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LancamentosDTO {

    private String name;

    private String description;

    private String type;

    private Double amount;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Boolean paid;

    private CategoriaEntity categoria;

}