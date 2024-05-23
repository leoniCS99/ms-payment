package ms.payment.application.useCase;

import ms.payment.application.gateway.PaymentGateway;
import ms.payment.domain.entity.Payment;
import ms.payment.domain.entity.PaymentStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePaymentTest {
    @InjectMocks
    private CreatePayment createPayment;

    @Mock
    private PaymentGateway paymentGateway;

    @Test
    @DisplayName("create payment return payment pending")
    void createPayment() {
        //Arrange
        Payment payment = new Payment();
        payment.setMethod("USD");
        payment.setStatus(PaymentStatus.PENDING);
        payment.setTimestamp(LocalDateTime.now());
        payment.setAmount(new BigDecimal(1000));

        when(paymentGateway.create(payment)).thenReturn(payment);

        //Act
        Payment sut = createPayment.create(payment);

        //Assert
        assertThat(sut).isNotNull().isEqualTo(payment);
        assertThat(sut.getStatus()).isEqualTo(PaymentStatus.PENDING);
    }
}