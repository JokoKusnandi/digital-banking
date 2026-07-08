package com.banking.common.validation;

import com.banking.common.annotation.NationalId;
import com.banking.common.util.RegexPattern;
import com.banking.common.util.ValidationUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NationalIdValidator
        implements ConstraintValidator<NationalId,String>{

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context){

        return ValidationUtil.match(
                RegexPattern.NIK,
                value
        );

    }

}
