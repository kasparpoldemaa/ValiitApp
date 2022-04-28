package com.example.demo.role;

import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import com.example.demo.userrole.UserRoleDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleRepository roleRepository;

    public Role setRole(String roleName) {
        return roleRepository.findByName(roleName);
    }

//    public void deleteById(Integer roleId) {
//        roleRepository.deleteById(roleId);
//    }
}
