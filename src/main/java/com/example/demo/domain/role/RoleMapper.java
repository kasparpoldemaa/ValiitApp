package com.example.demo.domain.role;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleFromRoleDto(RoleDto roleDto, @MappingTarget Role role);
}
