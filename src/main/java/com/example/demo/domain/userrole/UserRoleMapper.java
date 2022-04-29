package com.example.demo.domain.userrole;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRoleMapper {
//    @Mapping(source = "userId", target = "user.id")
//    @Mapping(source = "userUserName", target = "user.userName")
//    @Mapping(source = "userPassword", target = "user.password")
//    @Mapping(source = "roleId", target = "role.id")
//    @Mapping(source = "roleName", target = "role.name")
//    @Mapping(target = "id", ignore = true)

//    UserRole toEntity(NewUserRequest newUserRequest);

//    @InheritInverseConfiguration(name = "toEntity")
//    NewUserRequest toDto(UserRole userRole);

    List<NewUserRequest> toDtos(List<UserRole> userRole);


    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserRoleFromUserRoleDto(NewUserRequest newUserRequest, @MappingTarget UserRole userRole);
}
