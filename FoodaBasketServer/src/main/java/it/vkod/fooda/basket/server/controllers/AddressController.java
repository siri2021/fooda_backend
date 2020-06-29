package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Address;
import it.vkod.fooda.basket.server.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("basket/address/")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping("{addressId}")
    public Address getAddress(@PathVariable final BigInteger addressId) {
        return addressService.get(addressId).orElse(null);
    }

    @GetMapping("{userId}/page/{page}")
    public Page<Address> getAddressesByUser(@PathVariable final BigInteger userId, @PathVariable final int page) {
        return addressService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping
    public void addAddress(@RequestBody final Address address) {
        addressService.add(address);
    }

    @PutMapping("{addressId}")
    public void editAddress(@RequestBody final Address address, @PathVariable final BigInteger addressId) {
        if (addressService.exists(addressId).equals(true))
            addressService.edit(address, addressId);
    }

    @DeleteMapping("{addressId}")
    public void deleteAddress(@PathVariable final BigInteger addressId) {
        addressService.delete(addressId);
    }

    @DeleteMapping
    public void deleteAddress(@RequestBody final Address address) {
        addressService.delete(address);
    }

}
