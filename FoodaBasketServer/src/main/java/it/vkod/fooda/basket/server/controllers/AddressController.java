package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Address;
import it.vkod.fooda.basket.server.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("basket/address/")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping("{addressId}")
    public Address getAddress(@PathVariable final UUID id) {
        return addressService.get(id).orElse(null);
    }

    @GetMapping("{userId}")
    public Page<Address> getAddresssByUser(@PathVariable final UUID userId) {
        return addressService.getAll(userId);
    }

    @PostMapping
    public void addAddress(@RequestBody final Address address) {
        address.setId(UUID.randomUUID());
        addressService.add(address);
    }

    @PutMapping("{addressId}")
    public void editAddress(@RequestBody final Address address, @PathVariable final UUID addressId) {
        if (addressService.exists(addressId))
            addressService.edit(address, addressId);
    }

    @DeleteMapping("{addressId}")
    public void deleteAddress(@PathVariable final UUID addressId) {
        addressService.delete(addressId);
    }

    @DeleteMapping
    public void deleteAddress(@RequestBody final Address address) {
        addressService.delete(address);
    }

}
