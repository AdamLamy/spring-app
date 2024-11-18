package co2123.hw1.controller;

import co2123.hw1.domain.Machine;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MachineValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return Machine.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final Machine machine = (Machine) target;
        final int score = machine.getScore();
        final String genre = machine.getGenre();

        if (!(score >= 50 && score <= 750)) {
            errors.rejectValue("score", "", "Score must be between 50-750");
        }

        if (!genre.equals("Platform") && !genre.equals("Puzzle") && !genre.equals("Rhythm")) {
            errors.rejectValue("genre", "", "Genre must be \"Platform\", \"Puzzle\", or \"Rhythm\"");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tagline", "", "Tagline field cannot be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier", "", "Supplier field cannot be empty.");

    }

}