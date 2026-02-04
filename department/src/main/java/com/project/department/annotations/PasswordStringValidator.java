package com.project.department.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class PasswordStringValidator
        implements ConstraintValidator<PasswordStringValidation
        , String> {
    // Regex for password rules
    private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{10,}$";

    private static final Pattern pattern =
            Pattern.compile(PASSWORD_PATTERN);
    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext context) {
        // Let @NotNull handle null check
        if (password == null) {
            return true;
        }
        return pattern.matcher(password).matches();
    }
}