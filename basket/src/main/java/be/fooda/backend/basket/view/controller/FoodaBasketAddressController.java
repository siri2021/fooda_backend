package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketAddressRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketAddressDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketAddressDtoMapper;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketAddressRes;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;


@RestController
@RequestMapping("basket/address/")
@RequiredArgsConstructor
public class FoodaBasketAddressController {

    private final FoodaBasketAddressRepository basketAddressRepo;
    private final FoodaBasketAddressDtoMapper basketAddressDtoMapper;

    @GetMapping("apiBasketGetAddressById")
    @SneakyThrows
    public ResponseEntity<FoodaBasketAddressRes> apiBasketGetAddressById(@RequestParam @NotNull final Long addressId) {
        Optional<FoodaBasketAddressDto> oDto = basketAddressRepo.findById(addressId);
        return oDto.map(foodaBasketAddressDto -> new ResponseEntity<FoodaBasketAddressRes>(FoodaBasketAddressDtoMapper::dtoToResponse, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("getAllByUserId")
    public Page<FoodaBasketAddressDto> apiBasketGetAddressesByUser(@RequestParam final Long userId, @RequestParam final int page) {
        return basketAddressRepo.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void apiBasketAddAddress(@RequestBody final FoodaBasketAddressDto address) {
        basketAddressRepo.add(address);
    }

    @PutMapping("edit")
    public void apiBasketEditAddress(@RequestBody final FoodaBasketAddressDto address) {
        if (basketAddressRepo.exists(address.getAddressId()).equals(true))
            basketAddressRepo.edit(address, address.getAddressId());
    }

    @DeleteMapping("deleteByAddressId")
    public void apiBasketDeleteAddress(@RequestParam final Long addressId) {
        basketAddressRepo.delete(addressId);
    }

    @DeleteMapping("delete")
    public void apiBasketDeleteAddress(@RequestBody final FoodaBasketAddressDto address) {
        basketAddressRepo.delete(address);
    }

}
