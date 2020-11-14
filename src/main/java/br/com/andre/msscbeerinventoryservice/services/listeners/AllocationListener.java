package br.com.andre.msscbeerinventoryservice.services.listeners;

import br.com.andre.msscbeerinventoryservice.config.JmsConfig;
import br.com.andre.msscbeerinventoryservice.services.AllocationService;
import br.com.andre.msscbeerinventoryservice.web.model.events.AllocateOrderRequest;
import br.com.andre.msscbeerinventoryservice.web.model.events.AllocateOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllocationListener {

    private JmsTemplate jmsTemplate;
    private final AllocationService allocationService;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    public void listen(AllocateOrderRequest orderRequest) {
        AllocateOrderResult.AllocateOrderResultBuilder builder = AllocateOrderResult.builder();
        builder.beerOrderDto(orderRequest.getBeerOrderDto());

        try {
            Boolean allocationResult = allocationService.allocateOrder(orderRequest.getBeerOrderDto());

            if(allocationResult) {
                builder.pendingInventory(false);
            } else {
                builder.pendingInventory(true);
            }
        } catch (Exception e) {
            log.error("Allocation failed for Order Id: " + orderRequest.getBeerOrderDto().getId().toString());
            builder.allocationError(true);
        }

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
                builder.build());
    }

}
