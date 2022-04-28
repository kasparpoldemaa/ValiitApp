package com.example.demo.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T10:11:15+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        Integer id = null;
        String userName = null;
        String password = null;

        id = user.getId();
        userName = user.getUserName();
        password = user.getPassword();

        UserDto userDto = new UserDto( id, userName, password );

        return userDto;
    }

    @Override
    public void updateUserFromUserDto(UserDto userDto, User user) {
        if ( userDto == null ) {
            return;
        }

        if ( userDto.getId() != null ) {
            user.setId( userDto.getId() );
        }
        if ( userDto.getUserName() != null ) {
            user.setUserName( userDto.getUserName() );
        }
        if ( userDto.getPassword() != null ) {
            user.setPassword( userDto.getPassword() );
        }
    }
}
