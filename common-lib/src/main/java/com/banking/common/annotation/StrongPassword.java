package com.banking.common.annotation;

import com.banking.common.validation.StrongPasswordValidator;
import jakarta.validation.Constraint;
import org.springframework.messaging.handler.annotation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StrongPasswordValidator.class)

public @interface StrongPassword{

    String message() default "Weak Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
