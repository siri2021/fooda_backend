package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.User;
import it.vkod.fooda.basket.server.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("basket/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("{userId}")
    public User getUser(@PathVariable final UUID id) {
        return userService.get(id).orElse(null);
    }

    @PostMapping
    public void addUser(@RequestBody final User user) {
        user.setId(UUID.randomUUID());
        userService.add(user);
    }

    @PutMapping("{userId}")
    public void editUser(@RequestBody final User user, @PathVariable final UUID userId) {
        if (userService.exists(userId))
            userService.edit(user, userId);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable final UUID userId) {
        userService.delete(userId);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody final User user) {
        userService.delete(user);
    }

}
