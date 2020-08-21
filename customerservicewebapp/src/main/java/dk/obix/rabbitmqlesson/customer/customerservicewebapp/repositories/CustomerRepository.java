package dk.obix.rabbitmqlesson.customer.customerservicewebapp.repositories;

import dk.obix.rabbitmqlesson.customer.customerservicewebapp.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
