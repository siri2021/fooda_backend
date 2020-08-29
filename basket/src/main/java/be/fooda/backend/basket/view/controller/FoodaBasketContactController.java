package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.model.dto.FoodaBasketContactDto;
import be.fooda.backend.basket.service.impl.FoodaBasketContactServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basket/contact/")
@RequiredArgsConstructor
public class FoodaBasketContactController {

    private final FoodaBasketContactServiceImpl contactService;

    @GetMapping("getByContactId")
    public FoodaBasketContactDto getContact(@RequestParam final Long contactId) {
        return contactService.get(contactId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<FoodaBasketContactDto> getContactsByUser(@RequestParam final Long userId, @RequestParam final int page) {
        return contactService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addContact(@RequestBody final FoodaBasketContactDto contact) {
        contactService.add(contact);
    }

    @PutMapping("edit")
    public void editContact(@RequestBody final FoodaBasketContactDto contact) {
        if (contactService.exists(contact.getContactId()).equals(true))
            contactService.edit(contact, contact.getContactId());
    }

    @DeleteMapping("deleteByContactId")
    public void deleteContact(@RequestParam final Long contactId) {
        contactService.delete(contactId);
    }

    @DeleteMapping("delete")
    public void deleteContact(@RequestParam final FoodaBasketContactDto contact) {
        contactService.delete(contact);
    }

}
