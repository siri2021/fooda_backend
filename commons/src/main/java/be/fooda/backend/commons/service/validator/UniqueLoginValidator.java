package be.fooda.backend.commons.service.validator;

import be.fooda.backend.commons.dao.repo.FoodaUserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    private FoodaUserRepository foodaUserRepository;

    public void initialize(UniqueLogin constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        return login != null && !foodaUserRepository.findByLogin(login).isPresent();
    }

}

