package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.User;
import it.vkod.fooda.basket.server.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("basket/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("{userId}")
    public User getUser(@PathVariable final BigInteger userId) {
        return userService.get(userId).orElse(null);
    }

    @PostMapping
    public void addUser(@RequestBody final User user) {
        userService.add(user);
    }

    @PutMapping("{userId}")
    public void editUser(@RequestBody final User user, @PathVariable final BigInteger userId) {
        if (userService.exists(userId).equals(true))
            userService.edit(user, userId);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable final BigInteger userId) {
        userService.delete(userId);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody final User user) {
        userService.delete(user);
    }

}
