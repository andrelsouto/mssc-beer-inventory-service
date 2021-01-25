package br.com.andre.msscbeerinventoryservice.services;

import br.com.andre.msscbeerinventoryservice.web.model.BeerOrderDto;

public interface AllocationService {

    Boolean allocateOrder(BeerOrderDto beerOrderDto);

    void deallocateOrder(BeerOrderDto beerOrderDto);
}
