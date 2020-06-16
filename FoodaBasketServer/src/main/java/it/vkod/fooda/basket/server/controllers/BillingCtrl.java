package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Billing;
import it.vkod.fooda.basket.server.repositories.BillingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/billing")
public class BillingCtrl {

    @Autowired
    private BillingRepository repo;

    @PostMapping("insert")
    public void apiPostInsertBasketBilling(@NotNull @RequestBody final Billing billing) {
        if (repo.existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(billing.getFirstName(), billing.getLastName(),
                billing.getUserId(), billing.getAddress(), billing.getPostcode())) {

            apiPutUpdateBasketBilling(billing);

        } else {
            repo.save(billing);
        }
    }

    @PutMapping("update")
    public void apiPutUpdateBasketBilling(@NotNull @RequestBody Billing billing) {
        billing = repo.findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(billing.getFirstName(), billing.getLastName(),
                billing.getUserId(), billing.getAddress(), billing.getPostcode());
        repo.save(billing);
    }

    @DeleteMapping("delete")
    public void apiDeleteBasketBilling(@NotNull @RequestBody final Billing billing) {
        repo.delete(billing);
    }

    @DeleteMapping("delete/{user_id}")
    public void apiClearBasketContacts(@PathVariable("user_id") final String userId) {
        final Billing[] contacts = apiGetContacts(userId);
        Arrays.stream(contacts).forEach(this::apiDeleteBasketBilling);
    }

    @GetMapping("select/{user_id}")
    public Billing[] apiGetContacts(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Billing[]::new);
    }
}
