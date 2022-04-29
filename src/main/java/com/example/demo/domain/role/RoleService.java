package com.example.demo.domain.role;

import com.example.demo.domain.user.User;
import com.example.demo.service.register.NewUserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleRepository roleRepository;

    public Role getRole(NewUserRequest request) {
        return roleRepository.getById(request.getRoleId());
    }

    public List<RoleDto> getAllRoles() {
       return roleMapper.toDtos(roleRepository.findAll());
    }


//    public void deleteById(Integer roleId) {
//        roleRepository.deleteById(roleId);
//    }
}
