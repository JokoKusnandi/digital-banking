package com.banking.common.validation;

import com.banking.common.annotation.PhoneNumber;
import com.banking.common.util.RegexPattern;
import com.banking.common.util.ValidationUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator
        implements ConstraintValidator<PhoneNumber,String> {

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context){

        return ValidationUtil.match(
                RegexPattern.PHONE,
                value
        );

    }

}
