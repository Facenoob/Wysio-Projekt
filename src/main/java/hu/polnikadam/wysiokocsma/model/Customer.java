package hu.polnikadam.wysiokocsma.model;


import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
@Table
@RequiredArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private LiverStrength liverStrength;

    @Column
    @NotNull
    private int bicepsSize;

}
