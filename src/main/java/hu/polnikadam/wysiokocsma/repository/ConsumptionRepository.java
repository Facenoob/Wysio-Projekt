package hu.polnikadam.wysiokocsma.repository;

import hu.polnikadam.wysiokocsma.model.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}
