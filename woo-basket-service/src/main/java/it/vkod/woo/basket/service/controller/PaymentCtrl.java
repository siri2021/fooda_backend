package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.payloads.Payment;
import it.vkod.woo.basket.service.repositories.PaymentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/payments/")
public class PaymentCtrl {

    @Autowired
    private PaymentRepo repo;

    @PostMapping("insert")
    public void apiPostInsertBasketPayment(@NotNull @RequestBody final Payment payment) {
        repo.save(payment);
    }

    @DeleteMapping("delete")
    public void apiDeleteBasketPayment(@NotNull @RequestBody final Payment payment) {
        repo.delete(payment);
    }

    @DeleteMapping("delete/{user_id}")
    public void apiClearBasketPayments(@PathVariable("user_id") final String userId) {
        final Payment[] payments = apiGetPayments(userId);
        Arrays.stream(payments).forEach(this::apiDeleteBasketPayment);
    }

    @GetMapping("select/{user_id}")
    public Payment[] apiGetPayments(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Payment[]::new);
    }
}
