package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Payment;
import it.vkod.fooda.basket.server.repositories.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket")
public class PaymentCtrl {

    @Autowired
    private PaymentRepository repo;

    @PostMapping("/payments/insert")
    public void apiPostInsertBasketPayment(@NotNull @RequestBody final Payment payment) {
        repo.save(payment);
    }

    @DeleteMapping("/payments/delete")
    public void apiDeleteBasketPayment(@NotNull @RequestBody final Payment payment) {
        repo.delete(payment);
    }

    @DeleteMapping("/payments/delete/{user_id}")
    public void apiClearBasketPayments(@PathVariable("user_id") final String userId) {
        final Payment[] payments = apiGetPayments(userId);
        Arrays.stream(payments).forEach(this::apiDeleteBasketPayment);
    }

    @GetMapping("/payments/select/{user_id}")
    public Payment[] apiGetPayments(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Payment[]::new);
    }
}
