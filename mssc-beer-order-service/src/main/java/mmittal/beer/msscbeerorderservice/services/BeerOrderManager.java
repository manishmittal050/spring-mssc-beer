package mmittal.beer.msscbeerorderservice.services;

import mmittal.beer.brewery.model.BeerOrderDto;
import mmittal.beer.msscbeerorderservice.domain.BeerOrder;

import java.util.UUID;

public interface BeerOrderManager {
    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerOrderId, Boolean isValid);

    void beerOrderAllocationPassed(BeerOrderDto beerOrder);
    void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder);
    void beerOrderAllocationFailed(BeerOrderDto beerOrder);
}