package ms.payment.infrastructure.persistence;

import lombok.Getter;
import lombok.Setter;
import ms.payment.domain.entity.PaymentStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_PAYMENT")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private String currency;
    private String method;
    private LocalDateTime timestamp;
    private PaymentStatus status;
}
