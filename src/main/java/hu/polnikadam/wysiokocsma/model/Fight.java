package hu.polnikadam.wysiokocsma.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
@RequiredArgsConstructor
@Data
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private Date fightStart;

    @Column
    @NotNull
    private Date  fightEnd;

    @ManyToMany
    @Column
    @NotNull
    private List<Customer> fighters;

    @ManyToMany
    @Column
    @NotNull
    private List<Customer> winner;
}
