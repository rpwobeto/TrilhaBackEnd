package com.trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Campo nome não pode ser vazio ou nulo")
    @Size(min = 3, max = 45, message = "min 3 a 45 caracteres")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Campo de descrição não pode ser vazia ou nula")
    @Size(min = 15, max = 150, message = "min 15 a 150 caracteres")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Campo tipo não pode ser nula ou vazia")
    @Size(min = 3, max = 10, message = "min 3 a 10 caracteres")
    @Column(name = "type")
    private String type;

    @NotNull(message = "Valor  montante não pode ser nulo ou vazio")
    @Min(value = 0, message = "Valor mínimo permitido é 0")
    @Column(name = "amount")
    private Double amount;

    @Size(min = 0, message = "Valor mínimo permitido é 0")
    @Column(name = "date")
    private String date;

    @NotNull(message = "O campo pago não pode ser nulo ou vazio, aceita apenas sim ou não")
    @Column(name = "paid")
    private boolean paid = false;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    private CategoriaEntity categoria;

//    public Object findByCategoryId(Long id) {
//        return getDataLancamento();
//    };


    public boolean getPaid() {
        return paid;
    }

    public void isPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LancamentosEntity lancamentosEntity = (LancamentosEntity) o;
        return paid == lancamentosEntity.paid && Objects.equals(id, lancamentosEntity.id)
                && Objects.equals(name, lancamentosEntity.name)
                && Objects.equals(description, lancamentosEntity.description)
                && Objects.equals(type, lancamentosEntity.type)
                && Objects.equals(amount, lancamentosEntity.amount)
                && Objects.equals(date, lancamentosEntity.date)
                && Objects.equals(categoria, lancamentosEntity.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, amount, date, paid, categoria);
    }
}


