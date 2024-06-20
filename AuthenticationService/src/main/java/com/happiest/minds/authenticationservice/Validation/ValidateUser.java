package com.happiest.minds.authenticationservice.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = com.happiest.minds.authenticationservice.Validation.Uservalidator.class)
public @interface ValidateUser {

    public String message() default "Invalid userType: It should be either Teacher, Student or Admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
