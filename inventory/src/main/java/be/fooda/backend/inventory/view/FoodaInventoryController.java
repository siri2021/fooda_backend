package be.fooda.backend.inventory.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class FoodaInventoryController {

    @GetMapping("hello")
    public String hello() {
        return "Hello from Inventory Module... ";
    }

}
