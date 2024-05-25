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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindByIdPaymentTest {
    @InjectMocks
    private FindByIdPayment findByIdPayment;
    @Mock
    private PaymentGateway paymentGateway;

    @Test
    @DisplayName("find by id return payment")
    void findById() {
        //Arrange
        Payment payment = new Payment();
        payment.setMethod("REAL");
        payment.setStatus(PaymentStatus.PENDING);
        payment.setTimestamp(LocalDateTime.now());
        payment.setAmount(new BigDecimal(2000));

        when(paymentGateway.find(any())).thenReturn(payment);

        //Act
        Payment sut = findByIdPayment.find(any());

        //Assert
        assertThat(sut).isNotNull().isEqualTo(payment);
    }

}
