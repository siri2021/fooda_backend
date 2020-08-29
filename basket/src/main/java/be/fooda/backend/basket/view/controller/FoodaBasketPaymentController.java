package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import be.fooda.backend.basket.service.impl.FoodaBasketPaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("basket/payment/")
@RequiredArgsConstructor
public class FoodaBasketPaymentController {

    private final FoodaBasketPaymentServiceImpl paymentService;

    @GetMapping("getByPaymentId")
    public FoodaBasketPaymentDto getPayment(@RequestParam final Long paymentId) {
        return paymentService.get(paymentId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<FoodaBasketPaymentDto> getPaymentsByUser(@RequestParam final Long userId, @RequestParam final int page) {
        return paymentService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addPayment(@RequestBody final FoodaBasketPaymentDto payment) {
        paymentService.add(payment);
    }

    @PutMapping("edit")
    public void editPayment(@RequestBody final FoodaBasketPaymentDto payment) {
        if (paymentService.exists(payment.getPaymentId()).equals(true))
            paymentService.edit(payment, payment.getPaymentId());
    }

    @DeleteMapping("deleteByPaymentId")
    public void deletePayment(@RequestParam final Long paymentId) {
        paymentService.delete(paymentId);
    }

    @DeleteMapping("delete")
    public void deletePayment(@RequestBody final FoodaBasketPaymentDto payment) {
        paymentService.delete(payment);
    }

}
