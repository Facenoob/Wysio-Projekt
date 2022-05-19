package hu.polnikadam.wysiokocsma.controller;

import java.util.List;
import java.util.Optional;

import hu.polnikadam.wysiokocsma.model.Customer;
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
        List<Customer> customers = customerService.getAllCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customerData = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerData, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerToSave) {
        customerService.createCustomer(customerToSave);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customerToUpdate) {
        customerService.updateCustomer(id, customerToUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllCustomer() {
        customerService.deleteAllCustomer();
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
