package com.banking.common.converter;

import com.banking.common.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter
        implements AttributeConverter<Gender,String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute){

        return attribute.name();

    }

    @Override
    public Gender convertToEntityAttribute(String dbData){

        return Gender.valueOf(dbData);

    }

}
