package com.example.demo.user;

import com.example.demo.userrole.UserRoleDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;


    public User getAndSaveNewUser(UserRoleDto userRoleDto) {
        UserDto userDto = new UserDto();
        userDto.setUserName(userRoleDto.getUserUserName());
        userDto.setPassword(userRoleDto.getUserPassword());
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return user;
    }
}
