package com.trilha.back.financys.dtos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {

    private String name;

    private String type;

    private Double amount;

    //private Double total;

}
