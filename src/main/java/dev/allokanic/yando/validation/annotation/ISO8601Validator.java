package dev.allokanic.yando.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ISO8601Validator implements ConstraintValidator<IsISO8601, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            LocalDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
