package hu.polnikadam.wysiokocsma.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private LiverStrength liverStrength;

    @Column
    @NonNull
    private int bicepsSize;

}
