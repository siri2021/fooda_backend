package be.fooda.backend.delivery.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FoodaDeliveryController {

    @GetMapping
    public String hello() {
        return "Hello Delivery Module.. ";
    }
}
