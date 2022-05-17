package hu.polnikadam.wysiokocsma.service;

import hu.polnikadam.wysiokocsma.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    ResponseEntity<List<Customer>> getAllCustomer();

    ResponseEntity<Customer> getCustomerById(Long id);

    ResponseEntity<Customer> createCustomer(Customer customerToSave);

    ResponseEntity<Customer> updateCustomer(Long id, Customer customerToUpdate);

    ResponseEntity<HttpStatus> deleteCustomer(Long id);

    ResponseEntity<HttpStatus> deleteAllCustomer();
}
