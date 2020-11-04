package br.com.andre.msscbeerinventoryservice.web.controllers;

import br.com.andre.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import br.com.andre.msscbeerinventoryservice.services.BeerInventorySerivce;
import br.com.andre.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import br.com.andre.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    private final BeerInventorySerivce beerInventorySerivce;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId) {

        return beerInventorySerivce.findAllByBeerId(beerId);
    }
}
