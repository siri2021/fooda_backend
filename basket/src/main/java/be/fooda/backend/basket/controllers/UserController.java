package be.fooda.backend.basket.controllers;

import be.fooda.backend.basket.models.User;
import be.fooda.backend.basket.services.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Slf4j
@RestController
@RequestMapping("basket/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("getByUserId")
    public User getUser(@RequestParam final BigInteger userId) {
        return userService.get(userId).orElse(null);
    }

    @GetMapping("login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, passwordEncoder.encode(password)).orElse(null);
    }

    @GetMapping("logout")
    public void logoutUser(@RequestParam final BigInteger userId) {
        userService.logout(userId);
    }

    @PostMapping("add")
    public void addUser(@RequestBody final User user) {
        if (userService.exists(user.getUsername()).equals(false)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.add(user);
        } else {
            log.error("Username already exists..!");
        }
    }

    @PutMapping("edit")
    public void editUser(@RequestBody final User user) {
        if (userService.exists(user.getUserId()).equals(true)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.edit(user, user.getUserId());
        }
    }

    @DeleteMapping("deleteByUserId")
    public void deleteUser(@RequestParam final BigInteger userId) {
        userService.delete(userId);
    }

    @DeleteMapping("delete")
    public void deleteUser(@RequestBody final User user) {
        userService.delete(user);
    }

}
