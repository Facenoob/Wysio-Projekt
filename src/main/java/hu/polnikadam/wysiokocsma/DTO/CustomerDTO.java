package hu.polnikadam.wysiokocsma.DTO;

import hu.polnikadam.wysiokocsma.model.LiverStrength;
import lombok.Data;


@Data
public class CustomerDTO {

    private Long id;
    private String name;
    private LiverStrength liverStrength;
    private Integer bicepsSize;
}
