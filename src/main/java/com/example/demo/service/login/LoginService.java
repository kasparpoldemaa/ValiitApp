package com.example.demo.service.login;

import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.userrole.UserRole;
import com.example.demo.domain.userrole.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    public LoginResponse logIn(String userName, String password) {
        User user = userService.findUserByNameAndPassword(userName, password);
        UserRole userRole = userRoleService.getUserRoleByUserName(userName);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoleName(userRole.getRole().getName());

        return loginResponse;
    }
}
