package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Payment;
import it.vkod.fooda.basket.server.services.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("basket/payment/")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping("getByPaymentId")
    public Payment getPayment(@RequestParam final BigInteger paymentId) {
        return paymentService.get(paymentId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<Payment> getPaymentsByUser(@RequestParam final BigInteger userId, @RequestParam final int page) {
        return paymentService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addPayment(@RequestBody final Payment payment) {
        paymentService.add(payment);
    }

    @PutMapping("edit")
    public void editPayment(@RequestBody final Payment payment) {
        if (paymentService.exists(payment.getPaymentId()).equals(true))
            paymentService.edit(payment, payment.getPaymentId());
    }

    @DeleteMapping("deleteByPaymentId")
    public void deletePayment(@RequestParam final BigInteger paymentId) {
        paymentService.delete(paymentId);
    }

    @DeleteMapping("delete")
    public void deletePayment(@RequestBody final Payment payment) {
        paymentService.delete(payment);
    }

}
