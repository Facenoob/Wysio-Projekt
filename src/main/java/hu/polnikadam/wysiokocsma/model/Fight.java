package hu.polnikadam.wysiokocsma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
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
    private Date fightEnd;

    @ManyToMany
    @Column
    @NotNull
    private List<Customer> fighters;

    @ManyToMany
    @Column
    @NotNull
    private List<Customer> winner;
}
