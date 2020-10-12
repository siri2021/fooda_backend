package be.fooda.backend.contact.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contact")
public class FoodaContactController {

    @GetMapping("hello")
    public String getHello(@RequestParam final String name) {
        return "Hello " + name + " to you !! from Contact Module .. ";
    }

}
