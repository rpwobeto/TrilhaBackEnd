package com.trilha.back.financys.dtos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {

    //private String NameCategoria;

    private String type;

    private String amount;

    private Double total;

}
