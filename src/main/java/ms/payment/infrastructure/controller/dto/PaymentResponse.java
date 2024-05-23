package ms.payment.infrastructure.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponse {
    private BigDecimal amount;
    private String currency;
    private String method;
    private LocalDateTime timestamp;
    private PaymentStatusDto status;
}
