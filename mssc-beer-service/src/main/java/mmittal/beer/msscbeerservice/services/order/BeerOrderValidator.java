package mmittal.beer.msscbeerservice.services.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mmittal.beer.brewery.model.events.BeerOrderDto;
import mmittal.beer.msscbeerservice.repositories.BeerRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderValidator {
    private final BeerRepository beerRepository;
    public Boolean validateOrder(BeerOrderDto beerOrder){
        AtomicInteger beersNotFound = new AtomicInteger();
        beerOrder.getBeerOrderLines().forEach(orderline -> {
            if(beerRepository.findByUpc(orderline.getUpc()) == null){
                beersNotFound.incrementAndGet();
            }
        });
        return beersNotFound.get() == 0;
    }
}