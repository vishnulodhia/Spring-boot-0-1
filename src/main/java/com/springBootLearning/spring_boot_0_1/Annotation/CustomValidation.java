package com.springBootLearning.spring_boot_0_1.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CustomValidation implements ConstraintValidator<Validation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> role = List.of("USER","ADMIN");
        return role.contains(s);
    }
}
