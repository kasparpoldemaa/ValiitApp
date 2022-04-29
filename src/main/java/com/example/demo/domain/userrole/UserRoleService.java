package com.example.demo.domain.userrole;

import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    public List<NewUserRequest> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoleMapper.toDtos(userRoles);
    }




}
