package mmittal.beer.brewery.model.events;

import lombok.NoArgsConstructor;
import mmittal.beer.brewery.model.BeerDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}