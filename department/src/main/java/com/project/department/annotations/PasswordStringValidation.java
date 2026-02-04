package com.project.department.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = {PasswordStringValidator.class})
public @interface PasswordStringValidation {
    String message() default "Password should follow all the given 4 constraints";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}