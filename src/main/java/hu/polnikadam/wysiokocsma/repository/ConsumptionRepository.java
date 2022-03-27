package hu.polnikadam.wysiokocsma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.locks.Condition;

public interface ConsumptionRepository extends JpaRepository<Condition,Long> {
}
