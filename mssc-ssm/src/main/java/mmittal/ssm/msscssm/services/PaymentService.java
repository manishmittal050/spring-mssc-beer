package mmittal.ssm.msscssm.services;

import mmittal.ssm.msscssm.domain.Payment;
import mmittal.ssm.msscssm.domain.PaymentEvent;
import mmittal.ssm.msscssm.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}