package hu.polnikadam.wysiokocsma.repository;

import hu.polnikadam.wysiokocsma.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FightRepository extends JpaRepository<Fight,Long> {
}
