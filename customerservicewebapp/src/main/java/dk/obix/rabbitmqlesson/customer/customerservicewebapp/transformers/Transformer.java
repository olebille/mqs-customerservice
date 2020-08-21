package dk.obix.rabbitmqlesson.customer.customerservicewebapp.transformers;

public interface Transformer<ENTITY, DTO> {
    ENTITY toModel(DTO dto);

    DTO toDto(ENTITY model);
}
