package br.com.andre.msscbeerinventoryservice.web.mappers;

import br.com.andre.msscbeerinventoryservice.domain.BeerInventory;
import br.com.andre.msscbeerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-31.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
