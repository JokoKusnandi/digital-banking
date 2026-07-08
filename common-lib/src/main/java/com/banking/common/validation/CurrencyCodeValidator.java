package com.banking.common.validation;

import com.banking.common.annotation.CurrencyCode;
import com.banking.common.util.RegexPattern;
import com.banking.common.util.ValidationUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CurrencyCodeValidator
        implements ConstraintValidator<CurrencyCode,String>{

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context){

        return ValidationUtil.match(
                RegexPattern.CURRENCY,
                value
        );

    }

}
