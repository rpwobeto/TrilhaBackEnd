package com.trilha.back.financys.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryDTO {

    @NotBlank(message = "{name.not.blank}")
    @Size(min = 3, max = 15, message = "{name.size}")
    private String name;

    @NotBlank(message = "{description.not.blank}")
    @Size(min = 15, max = 50, message = "{description.size}")
    private String description;
}