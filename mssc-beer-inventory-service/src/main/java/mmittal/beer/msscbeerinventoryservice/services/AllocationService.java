package mmittal.beer.msscbeerinventoryservice.services;

import mmittal.beer.brewery.model.BeerOrderDto;

public interface AllocationService {

    Boolean allocateOrder(BeerOrderDto beerOrderDto);

}
