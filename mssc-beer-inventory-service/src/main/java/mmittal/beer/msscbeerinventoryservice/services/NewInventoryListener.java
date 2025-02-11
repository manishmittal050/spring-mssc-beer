package mmittal.beer.msscbeerinventoryservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mmittal.beer.brewery.model.events.NewInventoryEvent;
import mmittal.beer.msscbeerinventoryservice.config.JmsConfig;
import mmittal.beer.msscbeerinventoryservice.domain.BeerInventory;
import mmittal.beer.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){

        log.debug("Got inventory "+ event.toString());

        beerInventoryRepository.save(
                BeerInventory.builder()
                        .beerId(event.getBeerDto().getId())
                        .upc(event.getBeerDto().getUpc())
                        .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                        .build());

    }
}
