package com.example.demo.domain.role;

import com.example.demo.service.register.NewUserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleRepository roleRepository;

    public Role getRole(NewUserRequest request) {
        return roleRepository.getById(request.getRoleId());
    }

//    public void deleteById(Integer roleId) {
//        roleRepository.deleteById(roleId);
//    }
}
