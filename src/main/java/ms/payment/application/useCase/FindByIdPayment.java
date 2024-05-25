package ms.payment.application.useCase;

import ms.payment.application.gateway.PaymentGateway;
import ms.payment.domain.entity.Payment;

public class FindByIdPayment {

    private final PaymentGateway paymentGateway;

    public FindByIdPayment(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Payment find(Long id){
        return paymentGateway.find(id);
    }
}
