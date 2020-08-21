package dk.obix.rabbitmqlesson.customer.customerservicewebapp.transformers;

import dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos.CreateCustomerDto;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos.CustomerDto;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.models.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer implements Transformer<Customer, CustomerDto> {
    @Override
    public Customer toModel(CustomerDto customerDto) {
        Customer model = new Customer();
        model.setName(customerDto.getName());
        return model;
    }

    @Override
    public CustomerDto toDto(Customer model) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(model.getId());
        customerDto.setName(model.getName());
        return customerDto;
    }

    public Customer toModel(CreateCustomerDto createCustomerDto) {
        Customer model = new Customer();
        model.setName(createCustomerDto.getName());
        return model;
    }
}
