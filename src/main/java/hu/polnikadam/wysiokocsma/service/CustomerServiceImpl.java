package hu.polnikadam.wysiokocsma.service;

import hu.polnikadam.wysiokocsma.model.Customer;
import hu.polnikadam.wysiokocsma.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    public void createCustomer(Customer customerToSave) {
        Customer customer = new Customer();
        customer.setName(customerToSave.getName());
        customer.setBicepsSize(customerToSave.getBicepsSize());
        customer.setLiverStrength(customerToSave.getLiverStrength());
        customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerToUpdate) {
        Customer customerData = customerRepository.findById(id).get();
        customerData.setName(customerToUpdate.getName());
        customerData.setLiverStrength(customerToUpdate.getLiverStrength());
        customerData.setBicepsSize(customerToUpdate.getBicepsSize());
        return customerRepository.save(customerData);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAll();
    }

}
