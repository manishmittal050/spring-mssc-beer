package mmittal.beer.msscbeerservice.services.order;

import lombok.RequiredArgsConstructor;
import mmittal.beer.brewery.model.events.ValidateOrderRequest;
import mmittal.beer.brewery.model.events.ValidateOrderResult;
import mmittal.beer.msscbeerservice.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {
    private final BeerOrderValidator validator;
    private final JmsTemplate jmsTemplate;
    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest){
        Boolean isValid = validator.validateOrder(validateOrderRequest.getBeerOrder());
        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(isValid)
                        .orderId(validateOrderRequest.getBeerOrder().getId())
                        .build());
    }
}