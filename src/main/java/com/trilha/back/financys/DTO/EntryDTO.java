package com.trilha.back.financys.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryDTO {

    @NotBlank(message = "{name.not.blank}")
    @Size(min = 3, max = 15, message = "{name.size}")
    private String name;

    @NotBlank(message = "{description.not.blank}")
    @Size(min = 15, max = 50, message = "{description.size}")
    private String description;

    @NotBlank(message = "{type.not.blank}")
    @Size(min = 3, max = 10, message = "{type.size}")
    private String type;

    @NotNull(message = "{amount.not.null}")
    @Min(value = 0, message = "{amount.min}")
    private String amount;

    @NotBlank(message = "{dataEntry.not.blank}")
    private String date;

    @NotNull(message = "{paid.not.null}")
    private String paid;

}