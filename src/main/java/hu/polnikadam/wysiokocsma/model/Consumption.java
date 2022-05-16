package hu.polnikadam.wysiokocsma.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
@RequiredArgsConstructor
@Data
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @Column
    @NotNull
    private List<Drink> drink;

    @Column
    @NotNull
    private int numberOfDrinks;
}
