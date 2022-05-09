package com.example.demo.domain.contact;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userUserName", target = "user.userName")
    @Mapping(source = "userPassword", target = "user.password")
    Contact toEntity(ContactDto contactDto);

    @InheritInverseConfiguration(name = "toEntity")
    ContactDto toDto(Contact contact);

    List<ContactDto> toDtos(List <Contact> contacts);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);
}
