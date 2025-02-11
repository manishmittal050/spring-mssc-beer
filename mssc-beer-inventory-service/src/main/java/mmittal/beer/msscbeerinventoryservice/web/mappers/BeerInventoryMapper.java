package mmittal.beer.msscbeerinventoryservice.web.mappers;

import mmittal.beer.msscbeerinventoryservice.domain.BeerInventory;
import mmittal.beer.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}