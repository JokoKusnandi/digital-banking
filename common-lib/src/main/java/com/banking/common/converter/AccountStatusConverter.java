package com.banking.common.converter;

import com.banking.common.enums.AccountStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AccountStatusConverter
        implements AttributeConverter<AccountStatus,String> {

    @Override
    public String convertToDatabaseColumn(AccountStatus attribute){

        return attribute.name();

    }

    @Override
    public AccountStatus convertToEntityAttribute(String dbData){

        return AccountStatus.valueOf(dbData);

    }

}
