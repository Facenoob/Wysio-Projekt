package hu.polnikadam.wysiokocsma.model;
import static java.lang.Double.POSITIVE_INFINITY;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LiverStrength {

    BABY("Babamáj", 0.5),
    TEEN("Tinimáj", 2.5),
    UNI_SUTDENT("Egyetemistamáj", 3.0),
    DIAMOND("Gyémántmáj", 4.0),
    FANNI("Fannimáj", POSITIVE_INFINITY);

    private final String name;
    private final Double alcoholCapacity;
}
