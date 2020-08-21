package dk.obix.rabbitmqlesson.customer.customerservicewebapp.services;

import dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos.CreateCustomerDto;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos.CustomerDto;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.models.Customer;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.repositories.CustomerRepository;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.transformers.CustomerTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerTransformer customerTransformer;

    public CustomerService(CustomerRepository customerRepository, CustomerTransformer customerTransformer) {
        this.customerRepository = customerRepository;
        this.customerTransformer = customerTransformer;
    }

    @Transactional
    public CustomerDto createCustomer(CreateCustomerDto customerDto) {
        Customer customer = customerTransformer.toModel(customerDto);
        customerRepository.save(customer);
        return customerTransformer.toDto(customer);
    }

    @Transactional
    public CustomerDto getCustomer(Long customerId) {
        Optional<Customer> byId = customerRepository.findById(customerId);
        if (byId.isPresent()) {
            return customerTransformer.toDto(byId.get());
        } else {
            return null;

        }
    }
}
