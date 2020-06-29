package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Contact;
import it.vkod.fooda.basket.server.services.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("basket/contact/")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("{contactId}")
    public Contact getContact(@PathVariable final BigInteger contactId) {
        return contactService.get(contactId).orElse(null);
    }

    @GetMapping("{userId}/page/{page}")
    public Page<Contact> getContactsByUser(@PathVariable final BigInteger userId, @PathVariable final int page) {
        return contactService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping
    public void addContact(@RequestBody final Contact contact) {
        contactService.add(contact);
    }

    @PutMapping("{contactId}")
    public void editContact(@RequestBody final Contact contact, @PathVariable final BigInteger contactId) {
        if (contactService.exists(contactId).equals(true))
            contactService.edit(contact, contactId);
    }

    @DeleteMapping("{contactId}")
    public void deleteContact(@PathVariable final BigInteger contactId) {
        contactService.delete(contactId);
    }

    @DeleteMapping
    public void deleteContact(@RequestBody final Contact contact) {
        contactService.delete(contact);
    }

}
