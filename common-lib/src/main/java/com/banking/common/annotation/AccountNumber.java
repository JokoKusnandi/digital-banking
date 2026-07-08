package com.banking.common.annotation;

import com.banking.common.validation.AccountNumberValidator;
import jakarta.validation.Constraint;
import org.springframework.messaging.handler.annotation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountNumberValidator.class)

public @interface AccountNumber{

    String message() default "Invalid Account Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
