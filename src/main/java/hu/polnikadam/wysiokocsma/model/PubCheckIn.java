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
public class PubCheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    private Boolean detox;
}
