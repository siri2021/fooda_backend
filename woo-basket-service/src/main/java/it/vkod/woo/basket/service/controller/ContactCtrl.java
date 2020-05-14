package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.payloads.Contact;
import it.vkod.woo.basket.service.repositories.ContactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/contacts/")
public class ContactCtrl {

    @Autowired
    private ContactRepo repo;

    @PostMapping("insert")
    public void apiPostInsertBasketContact(@NotNull @RequestBody final Contact contact) {
        if (repo.existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(contact.getFirstName(), contact.getLastName(),
                contact.getUserId(), contact.getAddress(), contact.getPostcode())) {

            apiPutUpdateBasketContact(contact);

        } else {
            repo.save(contact);
        }
    }

    @PutMapping("update")
    public void apiPutUpdateBasketContact(@NotNull @RequestBody Contact contact) {
        contact = repo.findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(contact.getFirstName(), contact.getLastName(),
                contact.getUserId(), contact.getAddress(), contact.getPostcode());
        repo.save(contact);
    }

    @DeleteMapping("delete")
    public void apiDeleteBasketContact(@NotNull @RequestBody final Contact contact) {
        repo.delete(contact);
    }

    @DeleteMapping("delete/{user_id}")
    public void apiClearBasketContacts(@PathVariable("user_id") final long userId) {
        final Contact[] contacts = apiGetContacts(userId);
        Arrays.stream(contacts).forEach(this::apiDeleteBasketContact);
    }

    @GetMapping("select/{user_id}")
    public Contact[] apiGetContacts(@PathVariable("user_id") final long userId) {
        return repo.findAllByUserId(userId).toArray(Contact[]::new);
    }
}
