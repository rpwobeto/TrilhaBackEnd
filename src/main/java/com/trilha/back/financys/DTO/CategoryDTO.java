package com.trilha.back.financys.DTO;

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