package dk.obix.rabbitmqlesson.customer.customerservicewebapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER_TABLE")
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", allocationSize = 100)
    @GeneratedValue(generator = "customer_generator")
    private Long id;

    @Column(name = "NUMBER")
    private Long customerNumber;

    @Column(name = "NAME")
    private String name;


}
