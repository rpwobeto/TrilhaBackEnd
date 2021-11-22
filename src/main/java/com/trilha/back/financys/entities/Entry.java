package com.trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    private String name;
    private String description;
    private String type;
    private String amount;
    private LocalDate dataEntry;
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Object findByCategoryId(Long id) {
        return getDataEntry();
    };
}
