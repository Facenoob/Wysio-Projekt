package hu.polnikadam.wysiokocsma.repository;

import hu.polnikadam.wysiokocsma.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
