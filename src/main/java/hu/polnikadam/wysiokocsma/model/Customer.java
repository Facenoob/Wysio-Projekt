package hu.polnikadam.wysiokocsma.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@RequiredArgsConstructor()
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    @Getter
    @Setter
    @NonNull
    private String name;
    @Column
    @Getter
    @Setter
    @NonNull
    private LiverStrength liverStrength;
    @Column
    @Getter
    @Setter
    @NonNull
    private int  bicepsSize;

}
