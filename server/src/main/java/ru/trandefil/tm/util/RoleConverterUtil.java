package ru.trandefil.tm.util;

import lombok.NonNull;
import ru.trandefil.tm.entity.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoleConverterUtil implements AttributeConverter<Role,String> {

    @Override
    public String convertToDatabaseColumn(@NonNull Role attribute) {
        return attribute.name();
    }

    @Override
    public Role convertToEntityAttribute(@NonNull String dbData) {
        return Enum.valueOf(Role.class,dbData);
    }

}
