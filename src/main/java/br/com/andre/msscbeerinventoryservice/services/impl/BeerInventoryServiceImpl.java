package br.com.andre.msscbeerinventoryservice.services.impl;

import br.com.andre.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import br.com.andre.msscbeerinventoryservice.services.BeerInventorySerivce;
import br.com.andre.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import br.com.andre.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerInventoryServiceImpl implements BeerInventorySerivce {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    @Override
    public List<BeerInventoryDto> findAllByBeerId(UUID beerId) {
        log.debug("Finding Inventory for beerId:" + beerId);

        return beerInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
