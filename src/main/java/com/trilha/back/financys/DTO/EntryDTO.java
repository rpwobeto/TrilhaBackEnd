package com.trilha.back.financys.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryDTO {

    private String name;

    private String description;

    private String type;

    private String amount;

    private String date;

    private String paid;

}