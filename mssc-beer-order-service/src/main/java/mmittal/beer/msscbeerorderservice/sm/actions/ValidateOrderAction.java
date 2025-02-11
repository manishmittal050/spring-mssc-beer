package mmittal.beer.msscbeerorderservice.sm.actions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mmittal.beer.brewery.model.events.ValidateOrderRequest;
import mmittal.beer.msscbeerorderservice.config.JmsConfig;
import mmittal.beer.msscbeerorderservice.domain.BeerOrder;
import mmittal.beer.msscbeerorderservice.domain.BeerOrderEventEnum;
import mmittal.beer.msscbeerorderservice.domain.BeerOrderStatusEnum;
import mmittal.beer.msscbeerorderservice.repositories.BeerOrderRepository;
import mmittal.beer.msscbeerorderservice.services.BeerOrderManagerImpl;
import mmittal.beer.msscbeerorderservice.web.mappers.BeerOrderMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {
    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;
    private final JmsTemplate jmsTemplate;
    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
        String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));
        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_QUEUE, ValidateOrderRequest.builder()
                .beerOrder(beerOrderMapper.beerOrderToDto(beerOrder))
                .build());
        log.debug("Sent Validation request to queue for order id " + beerOrderId);
    }
}