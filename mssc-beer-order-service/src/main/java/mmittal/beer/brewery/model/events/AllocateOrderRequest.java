package mmittal.beer.brewery.model.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mmittal.beer.brewery.model.BeerOrderDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocateOrderRequest {
    private BeerOrderDto beerOrderDto;
}