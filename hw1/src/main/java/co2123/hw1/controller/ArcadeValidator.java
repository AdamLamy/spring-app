package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Arcade;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ArcadeValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return Arcade.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final Arcade arcade = (Arcade) target;

        for (Arcade a : Hw1Application.arcades) {
            if (a.getId() == arcade.getId()) {
                errors.rejectValue("id", "", "The ID of the arcade is already taken.");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name field cannot be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "", "Name field cannot be empty.");

    }

}
