package hu.polnikadam.wysiokocsma.repository;

import hu.polnikadam.wysiokocsma.model.PubCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubCheckInRepository extends JpaRepository<PubCheckIn, Long> {
}
