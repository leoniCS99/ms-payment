package ms.payment.infrastructure.controller;

import ms.payment.application.useCase.CreatePayment;
import ms.payment.application.useCase.FindByIdPayment;
import ms.payment.domain.entity.Payment;
import ms.payment.infrastructure.controller.dto.CreatePaymentRequest;
import ms.payment.infrastructure.controller.dto.PaymentResponse;
import ms.payment.infrastructure.gateways.PaymentEntityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {
    private final CreatePayment createPayment;

    private final FindByIdPayment findByIdPayment;
    private final PaymentEntityMapper paymentEntityMapper;

    public PaymentController(CreatePayment createPayment, FindByIdPayment findByIdPayment, PaymentEntityMapper paymentEntityMapper) {
        this.createPayment = createPayment;
        this.findByIdPayment = findByIdPayment;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    @PostMapping
    ResponseEntity<PaymentResponse> save(@RequestBody CreatePaymentRequest createPaymentRequest) {
        Payment paymentCreate = paymentEntityMapper.convertToPayment(createPaymentRequest);
        Payment savePayment = createPayment.create(paymentCreate);
        return ResponseEntity.ok(paymentEntityMapper.convertToPaymentResponse(savePayment));
    }

    @GetMapping("/{id}")
    ResponseEntity<PaymentResponse> find(@PathVariable Long id) {
        Payment paymentDto = findByIdPayment.find(id);
        return ResponseEntity.ok(paymentEntityMapper.convertToPaymentResponse(paymentDto));
    }

}
