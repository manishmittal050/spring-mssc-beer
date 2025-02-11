package mmittal.beer.brewery.model.events;

import lombok.*;
import mmittal.beer.brewery.model.BeerDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -5781515597148163111L;

    private BeerDto beerDto;
}