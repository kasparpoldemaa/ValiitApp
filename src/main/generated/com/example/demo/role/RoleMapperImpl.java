package com.example.demo.role;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-27T15:56:31+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        Integer id = null;
        String name = null;

        id = role.getId();
        name = role.getName();

        RoleDto roleDto = new RoleDto( id, name );

        return roleDto;
    }

    @Override
    public void updateRoleFromRoleDto(RoleDto roleDto, Role role) {
        if ( roleDto == null ) {
            return;
        }

        if ( roleDto.getId() != null ) {
            role.setId( roleDto.getId() );
        }
        if ( roleDto.getName() != null ) {
            role.setName( roleDto.getName() );
        }
    }
}
