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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/costomers")
    public ResponseEntity<List<Customer>> getAllCostumer(@RequestParam(required = false) String name) {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            if (name == null)
                customerRepository.findAll().forEach(customers::add);

            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/costomers/{id}")
    public ResponseEntity<Customer> getCostumerById(@PathVariable("id") long id) {
        Optional<Customer> costomerData = customerRepository.findById(id);
        if (costomerData.isPresent()) {
            return new ResponseEntity<>(costomerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/costomers")
    public ResponseEntity<Customer> createCostumer(@RequestBody Customer customer) {
        try {
            Customer _customer = customerRepository
                    .save(new Customer(customer.getName(), customer.getLiverStrength(), customer.getBicepsSize()));
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/costomers/{id}")
    public ResponseEntity<Customer> updateCostumer(@PathVariable("id") long id, @RequestBody Customer customer) {
        Optional<Customer> costomerData = customerRepository.findById(id);
        if (costomerData.isPresent()) {
            Customer _customer = costomerData.get();
            _customer.setName(customer.getName());
            _customer.setLiverStrength(customer.getLiverStrength());
            _customer.setBicepsSize(customer.getBicepsSize());
            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/costomers/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/costomers")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            customerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
