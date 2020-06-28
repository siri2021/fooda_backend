package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Contact;
import it.vkod.fooda.basket.server.services.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("basket/contact/")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("{contactId}")
    public Contact getContact(@PathVariable final UUID id) {
        return contactService.get(id).orElse(null);
    }

    @GetMapping("{userId}")
    public Page<Contact> getContactsByUser(@PathVariable final UUID userId) {
        return contactService.getAll(userId);
    }

    @PostMapping
    public void addContact(@RequestBody final Contact contact) {
        contact.setId(UUID.randomUUID());
        contactService.add(contact);
    }

    @PutMapping("{contactId}")
    public void editContact(@RequestBody final Contact contact, @PathVariable final UUID contactId) {
        if (contactService.exists(contactId))
            contactService.edit(contact, contactId);
    }

    @DeleteMapping("{contactId}")
    public void deleteContact(@PathVariable final UUID contactId) {
        contactService.delete(contactId);
    }

    @DeleteMapping
    public void deleteContact(@RequestBody final Contact contact) {
        contactService.delete(contact);
    }

}
