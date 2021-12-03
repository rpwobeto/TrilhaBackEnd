package com.trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.not.blank}")
    @Size(min = 3, max = 15, message = "{name.size}")
    private String name;

    @NotBlank(message = "{description.not.blank}")
    @Size(min = 15, max = 50, message = "{description.size}")
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Entry> entry;

    public Category(int indexOf) {
    }

}