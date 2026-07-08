package com.banking.common.annotation;

import com.banking.common.validation.CurrencyCodeValidator;
import jakarta.validation.Constraint;
import org.springframework.messaging.handler.annotation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrencyCodeValidator.class)

public @interface CurrencyCode{

    String message() default "Invalid Currency";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
