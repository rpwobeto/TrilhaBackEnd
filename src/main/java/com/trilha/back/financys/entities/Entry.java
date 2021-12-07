package com.trilha.back.financys.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_entry")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull @NotEmpty(message = "{name.ent.not.empty}")
    @Size(min = 3, max = 15)
    private String name;

    @Column(name = "description")
    @NotNull @NotEmpty(message = "{description.ent.not.empty}")
    @Size(min = 15, max = 150)
    private String description;

    @Column(name = "type")
    @NotNull @NotEmpty(message = "{type.not.empty}")
    @Size(min = 3, max = 10)
    private String type;

    @Column(name = "amount")
    @NotNull @NotEmpty(message = "{amount.not.empty}")
    @Min(value = 0)
    private String amount;

    @Column(name = "date")
    @NotNull @NotEmpty(message = "{date.not.empty}")
    private LocalDate date;

    @NotNull @NotEmpty(message = "{paid.not.empty}")
    @Column(name = "paid")
    private boolean paid = false;

    private List<Category> categoryId = new ArrayList<>();

}
