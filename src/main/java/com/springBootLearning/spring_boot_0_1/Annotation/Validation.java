package com.springBootLearning.spring_boot_0_1.Annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//use the interface name for validation as annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = CustomValidation.class)
public @interface Validation {
    String message() default "Role of user can be admin or user";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
