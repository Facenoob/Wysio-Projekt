package hu.polnikadam.wysiokocsma.repository;

import hu.polnikadam.wysiokocsma.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long>{
}
