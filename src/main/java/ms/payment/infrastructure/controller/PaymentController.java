package ms.payment.infrastructure.controller;

import ms.payment.application.useCase.CreatePayment;
import ms.payment.domain.entity.Payment;
import ms.payment.infrastructure.controller.dto.CreatePaymentRequest;
import ms.payment.infrastructure.controller.dto.PaymentResponse;
import ms.payment.infrastructure.gateways.PaymentEntityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {
    private final CreatePayment createPayment;
    private final PaymentEntityMapper paymentEntityMapper;

    public PaymentController(CreatePayment createPayment, PaymentEntityMapper paymentEntityMapper) {
        this.createPayment = createPayment;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    @PostMapping
    ResponseEntity<PaymentResponse> save(@RequestBody CreatePaymentRequest createPaymentRequest) {
        Payment paymentCreate = paymentEntityMapper.convertToPayment(createPaymentRequest);
        Payment savePayment = createPayment.create(paymentCreate);
        return ResponseEntity.ok(paymentEntityMapper.convertToPaymentResponse(savePayment));
    }

}
