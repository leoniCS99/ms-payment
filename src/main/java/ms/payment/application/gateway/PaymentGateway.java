package ms.payment.application.gateway;

import ms.payment.domain.entity.Payment;

public interface PaymentGateway {
    Payment create(Payment payment);
}
