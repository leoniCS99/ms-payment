package ms.payment.application.useCase;

import ms.payment.application.gateway.PaymentGateway;
import ms.payment.domain.entity.Payment;

public class CreatePayment {
    private final PaymentGateway paymentGateway;

    public CreatePayment(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Payment create(Payment payment) {
        return paymentGateway.create(payment);
    }
}
