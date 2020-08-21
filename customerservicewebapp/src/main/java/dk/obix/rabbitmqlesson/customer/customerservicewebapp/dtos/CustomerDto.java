package dk.obix.rabbitmqlesson.customer.customerservicewebapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String name;
}
