package com.example.demo.domain.userrole;

import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.service.register.NewUserRequest;
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


    public UserRole saveUserRole(NewUserRequest request) {

        Role role = roleService.getRole(request);
        User user = userService.getUser(request);

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleRepository.save(userRole);

        return userRole;
    }
}
