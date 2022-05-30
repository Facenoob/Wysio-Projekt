package hu.polnikadam.wysiokocsma.controller;

import java.util.List;

import hu.polnikadam.wysiokocsma.DTO.CustomerDTO;
import hu.polnikadam.wysiokocsma.model.Customer;
import hu.polnikadam.wysiokocsma.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> customers = customerService.getAllCustomer();
        return customers;
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

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllCustomer() {
        customerService.deleteAllCustomer();
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
