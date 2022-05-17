package hu.polnikadam.wysiokocsma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hu.polnikadam.wysiokocsma.model.Customer;
import hu.polnikadam.wysiokocsma.repository.CustomerRepository;
import hu.polnikadam.wysiokocsma.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerToSave) {
        return customerService.createCustomer(customerToSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customerToUpdate) {
        return customerService.updateCustomer(id, customerToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
        return customerService.deleteCustomer(id);
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllCustomer() {
        return customerService.deleteAllCustomer();
    }
}
