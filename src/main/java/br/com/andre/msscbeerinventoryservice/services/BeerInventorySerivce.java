package br.com.andre.msscbeerinventoryservice.services;

import br.com.andre.msscbeerinventoryservice.web.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventorySerivce {

    List<BeerInventoryDto> findAllByBeerId(UUID beerId);
}
