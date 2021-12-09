package com.trilha.back.financys.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryDTO {

    private String name;

    private String description;
}