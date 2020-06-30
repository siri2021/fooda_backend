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

    @GetMapping("getByAddressId")
    public Address getAddress(@RequestParam final BigInteger addressId) {
        return addressService.get(addressId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<Address> getAddressesByUser(@RequestParam final BigInteger userId, @RequestParam final int page) {
        return addressService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addAddress(@RequestBody final Address address) {
        addressService.add(address);
    }

    @PutMapping("edit")
    public void editAddress(@RequestBody final Address address) {
        if (addressService.exists(address.getAddressId()).equals(true))
            addressService.edit(address, address.getAddressId());
    }

    @DeleteMapping("deleteByAddressId")
    public void deleteAddress(@RequestParam final BigInteger addressId) {
        addressService.delete(addressId);
    }

    @DeleteMapping("delete")
    public void deleteAddress(@RequestBody final Address address) {
        addressService.delete(address);
    }

}
