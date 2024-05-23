package ms.payment.infrastructure.gateways;

import ms.payment.application.gateway.PaymentGateway;
import ms.payment.domain.entity.Payment;
import ms.payment.infrastructure.persistence.PaymentEntity;
import ms.payment.infrastructure.persistence.PaymentRepository;

public class PaymentRepositoryGateway implements PaymentGateway {
    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;

    public PaymentRepositoryGateway(PaymentRepository paymentRepository, PaymentEntityMapper paymentEntityMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    @Override
    public Payment create(Payment payment) {
        PaymentEntity paymentEntity = paymentEntityMapper.convertToEntity(payment);
        PaymentEntity savedPaymentEntity = paymentRepository.save(paymentEntity);
        return paymentEntityMapper.convertToPayment(savedPaymentEntity);
    }
}
