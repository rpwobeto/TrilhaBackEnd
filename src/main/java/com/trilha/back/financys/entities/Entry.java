package com.trilha.back.financys.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_entry")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Double amount;

    @NotBlank(message = "{dataEntry.not.blank}")

    private String dataEntry;

    @NotNull(message = "{paid.not.null}")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Object findByCategoryId(Long id) {

        return getDataEntry();
    };
}
