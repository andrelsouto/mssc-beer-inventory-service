package br.com.andre.msscbeerinventoryservice.config;

import br.com.andre.msscbeerinventoryservice.events.NewInventoryEvent;
import br.com.andre.msscbeerinventoryservice.web.model.events.AllocateOrderRequest;
import br.com.andre.msscbeerinventoryservice.web.model.events.AllocateOrderResult;
import br.com.andre.msscbeerinventoryservice.web.model.events.DeallocateOrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConfig {

    public static final String NEW_INVENTORY_QUEUE= "new-inventory";
    public static final String ALLOCATE_ORDER_QUEUE = "allocate-order";
    public static final String ALLOCATE_ORDER_RESPONSE_QUEUE = "allocate-order-response";
    public static final String DEALLOCATE_ORDER_QUEUE = "deallocate-order";


    @Bean
    public MessageConverter jacksonJmsConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
        typeIdMappings.put("JMS_TYPE", NewInventoryEvent.class);
        typeIdMappings.put("JMS_ALLOCATE_ORDER_REQUEST", AllocateOrderRequest.class);
        typeIdMappings.put("JMS_ALLOCATE_ORDER_RESPONSE", AllocateOrderResult.class);
        typeIdMappings.put("JMS_DEALLOCATE_FAILURE_EVENT", DeallocateOrderRequest.class);
        converter.setTargetType(MessageType.TEXT);
        converter.setObjectMapper(objectMapper);
        converter.setTypeIdMappings(typeIdMappings);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
