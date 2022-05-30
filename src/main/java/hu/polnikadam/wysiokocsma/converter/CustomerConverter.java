package hu.polnikadam.wysiokocsma.converter;

import hu.polnikadam.wysiokocsma.DTO.CustomerDTO;
import hu.polnikadam.wysiokocsma.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerConverter {
    public CustomerDTO toDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setLiverStrength(customer.getLiverStrength());
        customerDTO.setBicepsSize(customer.getBicepsSize());
        return new CustomerDTO();
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getLiverStrength(), customerDTO.getBicepsSize());
    }
}
