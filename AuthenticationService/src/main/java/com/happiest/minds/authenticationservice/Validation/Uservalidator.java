package com.happiest.minds.authenticationservice.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class Uservalidator implements ConstraintValidator<ValidateUser,String>
    {
        @Override
        public boolean isValid(String userType, ConstraintValidatorContext constraintValidatorContext) {
            List<String> userTypes= Arrays.asList("Teacher","Admin","Student");
            return userTypes.contains(userType);
        }
    }


