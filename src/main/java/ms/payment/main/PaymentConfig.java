package ms.payment.main;

import ms.payment.application.gateway.PaymentGateway;
import ms.payment.application.useCase.CreatePayment;
import ms.payment.infrastructure.gateways.PaymentEntityMapper;
import ms.payment.infrastructure.gateways.PaymentRepositoryGateway;
import ms.payment.infrastructure.persistence.PaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    CreatePayment createPayment(PaymentGateway paymentGateway) {
        return new CreatePayment(paymentGateway);
    }

    @Bean
    PaymentGateway paymentGateway(PaymentRepository paymentRepository, PaymentEntityMapper paymentEntityMapper) {
        return new PaymentRepositoryGateway(paymentRepository, paymentEntityMapper);
    }
}
