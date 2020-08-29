package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.model.dto.FoodaBasketUserDto;
import be.fooda.backend.basket.service.impl.FoodaBasketUserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("basket/user/")
@RequiredArgsConstructor
public class FoodaBasketUserController {

    private final FoodaBasketUserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("getByUserId")
    public FoodaBasketUserDto getUser(@RequestParam final Long userId) {
        return userService.get(userId).orElse(null);
    }

    @GetMapping("login")
    public FoodaBasketUserDto loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, passwordEncoder.encode(password)).orElse(null);
    }

    @GetMapping("logout")
    public void logoutUser(@RequestParam final Long userId) {
        userService.logout(userId);
    }

    @PostMapping("add")
    public void addUser(@RequestBody final FoodaBasketUserDto user) {
        if (userService.exists(user.getLogin()).equals(false)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.add(user);
        } else {
            log.error("Username already exists..!");
        }
    }

    @PutMapping("edit")
    public void editUser(@RequestBody final FoodaBasketUserDto user) {
        if (userService.exists(user.getUserId()).equals(true)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.edit(user, user.getUserId());
        }
    }

    @DeleteMapping("deleteByUserId")
    public void deleteUser(@RequestParam final Long userId) {
        userService.delete(userId);
    }

    @DeleteMapping("delete")
    public void deleteUser(@RequestBody final FoodaBasketUserDto user) {
        userService.delete(user);
    }

}
