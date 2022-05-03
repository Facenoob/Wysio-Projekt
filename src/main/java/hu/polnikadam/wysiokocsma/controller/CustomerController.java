package hu.polnikadam.wysiokocsma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hu.polnikadam.wysiokocsma.model.Customer;
import hu.polnikadam.wysiokocsma.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        try {
            List<Customer> customers = new ArrayList<>();
            customers.addAll(customerRepository.findAll());
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
        Optional<Customer> customerData = customerRepository.findById(id);
        if (customerData.isPresent()) {
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerToSave) {
        try {
            Customer customer = new Customer();

            customer.setName(customerToSave.getName());
            customer.setBicepsSize(customerToSave.getBicepsSize());
            customer.setLiverStrength(customerToSave.getLiverStrength());

            customerRepository.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customerToUpdate) {
        Optional<Customer> customerData = customerRepository.findById(id);
        if (customerData.isPresent()) {
            Customer customer = customerData.get();
            customer.setName(customerToUpdate.getName());
            customer.setLiverStrength(customerToUpdate.getLiverStrength());
            customer.setBicepsSize(customerToUpdate.getBicepsSize());
            return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllCustomer() {
        try {
            customerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
