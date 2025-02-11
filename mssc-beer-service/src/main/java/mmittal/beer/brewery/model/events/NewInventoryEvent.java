package mmittal.beer.brewery.model.events;

import lombok.NoArgsConstructor;
import mmittal.beer.brewery.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}