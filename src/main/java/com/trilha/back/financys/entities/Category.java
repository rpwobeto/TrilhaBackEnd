package com.trilha.back.financys.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "tb_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name" )
    @NotNull @NotEmpty(message = "{name.cat.not.empty}")
    @Size(min = 3, max = 15)
    private String name;

    @NotNull @NotEmpty(message = "{description.cat.not.empty}")
    @Size(min = 15, max = 50)
    @Column(name = "description")
    private String description;

}