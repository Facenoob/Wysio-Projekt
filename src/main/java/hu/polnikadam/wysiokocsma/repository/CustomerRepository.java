package hu.polnikadam.wysiokocsma.repository;

import hu.polnikadam.wysiokocsma.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
