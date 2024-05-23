package ms.payment.infrastructure.gateways;

import ms.payment.domain.entity.Payment;
import ms.payment.infrastructure.controller.dto.CreatePaymentRequest;
import ms.payment.infrastructure.controller.dto.PaymentResponse;
import ms.payment.infrastructure.persistence.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {
    PaymentEntity convertToEntity(Payment payment);
    Payment convertToPayment(PaymentEntity paymentEntity);
    Payment convertToPayment(CreatePaymentRequest createPaymentRequest);
    PaymentResponse convertToPaymentResponse(Payment payment);
}
