package dk.obix.rabbitmqlesson.customer.customerservicewebapp.controllers;

import dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos.CreateCustomerDto;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos.CustomerDto;
import dk.obix.rabbitmqlesson.customer.customerservicewebapp.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer/{customerId}")
    public @ResponseBody
    ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @PostMapping(path = "customer", consumes = "application/json")
    public ResponseEntity<CustomerDto> customerCreate(@RequestBody CreateCustomerDto createCustomerDto) {
        return ResponseEntity.ok(customerService.createCustomer(createCustomerDto));
    }
}
