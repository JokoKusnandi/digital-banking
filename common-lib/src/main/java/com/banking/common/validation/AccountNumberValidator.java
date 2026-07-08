package com.banking.common.validation;

import com.banking.common.annotation.AccountNumber;
import com.banking.common.util.RegexPattern;
import com.banking.common.util.ValidationUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountNumberValidator
        implements ConstraintValidator<AccountNumber,String>{

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context){

        return ValidationUtil.match(
                RegexPattern.ACCOUNT_NUMBER,
                value
        );

    }

}
