package be.fooda.backend.basket.controllers;

import be.fooda.backend.basket.models.Contact;
import be.fooda.backend.basket.services.impl.ContactServiceImpl;
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

    @GetMapping("getByContactId")
    public Contact getContact(@RequestParam final BigInteger contactId) {
        return contactService.get(contactId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<Contact> getContactsByUser(@RequestParam final BigInteger userId, @RequestParam final int page) {
        return contactService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addContact(@RequestBody final Contact contact) {
        contactService.add(contact);
    }

    @PutMapping("edit")
    public void editContact(@RequestBody final Contact contact) {
        if (contactService.exists(contact.getContactId()).equals(true))
            contactService.edit(contact, contact.getContactId());
    }

    @DeleteMapping("deleteByContactId")
    public void deleteContact(@RequestParam final BigInteger contactId) {
        contactService.delete(contactId);
    }

    @DeleteMapping("delete")
    public void deleteContact(@RequestParam final Contact contact) {
        contactService.delete(contact);
    }

}
