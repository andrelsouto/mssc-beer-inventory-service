package br.com.andre.msscbeerinventoryservice.web.model.events;

import br.com.andre.msscbeerinventoryservice.web.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeallocateOrderRequest {

    private BeerOrderDto beerOrderDto;

}
