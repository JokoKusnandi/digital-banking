package com.banking.common.annotation;

import com.banking.common.validation.NationalIdValidator;
import jakarta.validation.Constraint;
import org.springframework.messaging.handler.annotation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalIdValidator.class)

public @interface NationalId{

    String message() default "Invalid NIK";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
