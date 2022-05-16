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
public class PubCheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private Date PubCheckInFrom;

    @Column
    @NotNull
    private Date PubCheckInTo;

    @OneToMany
    @Column
    @NotNull
    private List<Consumption> consumptionList;

    @Column
    @NotNull
    private boolean  detox;
}
