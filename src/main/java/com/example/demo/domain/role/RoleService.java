package com.example.demo.domain.role;

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
