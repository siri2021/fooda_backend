package it.vkod.fooda.customer.frontend.utils;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PhoneNumber {
    @NotEmpty
    private String value;

    @NotEmpty
    private String locale;
}
