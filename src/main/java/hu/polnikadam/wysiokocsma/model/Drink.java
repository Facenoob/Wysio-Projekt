package hu.polnikadam.wysiokocsma.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@RequiredArgsConstructor
@Data
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private double  abv;

    @Column
    @NotNull
    private double  volume;
}
