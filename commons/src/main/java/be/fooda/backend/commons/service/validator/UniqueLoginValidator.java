package be.fooda.backend.commons.service.validator;

import be.fooda.backend.commons.dao.repo.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    private UserRepository userRepository;

    public void initialize(UniqueLogin constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        return login != null && !userRepository.findByLogin(login).isPresent();
    }

}

