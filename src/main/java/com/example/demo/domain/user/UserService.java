package com.example.demo.domain.user;

import com.example.demo.service.register.NewUserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public User getUser(NewUserRequest request) {
        return userRepository.findByUserName(request.getUserName());
    }

    public User addNewUser(NewUserRequest request) {
        User user = userMapper.toEntity(request);
        userRepository.save(user);
        return user;
    }
}
