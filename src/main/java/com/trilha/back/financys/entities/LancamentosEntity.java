package com.trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_lancamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class LancamentosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Campo nome não pode ser vazio ou nulo")
    @Size(min = 3, max = 45, message = "min 3 a 45 caracteres")
    private String name;

    @NotNull(message = "Campo de descrição não pode ser vazia ou nula")
    @Size(min = 15, max = 150, message = "min 15 a 150 caracteres")
    private String description;

    @NotNull(message = "Campo tipo não pode ser nula ou vazia")
    @Size(min = 3, max = 10, message = "min 3 a 10 caracteres")
    private String type;

    @NotNull(message = "Valor  montante não pode ser nulo ou vazio")
    @Min(value = 0, message = "Valor mínimo permitido é 0")
    private String amount;

    @Size(min = 0, message = "Valor mínimo permitido é 0")
    @Column(name = "data")
    private String date;

    @NotNull(message = "O campo pago não pode ser nulo ou vazio, aceita apenas sim ou não")
    private boolean paid;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria_id;

}
