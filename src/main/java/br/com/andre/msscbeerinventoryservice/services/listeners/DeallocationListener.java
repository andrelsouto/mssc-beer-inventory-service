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
public class DeallocationListener {

    private final AllocationService allocationService;

    @JmsListener(destination = JmsConfig.DEALLOCATE_ORDER_QUEUE)
    public void listen(AllocateOrderRequest orderRequest) {

        allocationService.deallocateOrder(orderRequest.getBeerOrderDto());
    }

}
