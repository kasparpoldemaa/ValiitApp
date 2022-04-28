package com.example.demo.userrole;

import com.example.demo.role.Role;
import com.example.demo.role.RoleDto;
import com.example.demo.role.RoleService;
import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import com.example.demo.user.UserService;
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

    public List<UserRoleDto> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoleMapper.toDtos(userRoles);
    }

    public UserRoleDto addNewUserAndRole(UserRoleDto userRoleDto) {

        User user = userService.getAndSaveNewUser(userRoleDto);
        Role role = roleService.getAndSaveNewRole(userRoleDto);

        UserRole userRoleSave = new UserRole();
        userRoleSave.setRole(role);
        userRoleSave.setUser(user);
        userRoleRepository.save(userRoleSave);

        return userRoleMapper.toDto(userRoleSave);
    }



}
