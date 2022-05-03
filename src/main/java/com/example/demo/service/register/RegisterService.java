package com.example.demo.service.register;

import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.studentprofile.StudentProfileService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.userrole.UserRole;
import com.example.demo.domain.userrole.UserRoleService;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterService {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private ContactService contactService;

    @Resource
    private StudentProfileService studentProfileService;

    @Resource
    private StudentService studentService;


    public NewUserResponse addNewUser(NewUserRequest request) {

        User user = userService.addNewUser(request);
        UserRole userRole = userRoleService.saveUserRole(request);

        NewUserResponse newUserResponse = new NewUserResponse();
        newUserResponse.setUserId(user.getId());
        newUserResponse.setRoleId(userRole.getRole().getId());

        // UserService abil salvestada user objekt
        // UserRoleService abil salvesta roll

        return newUserResponse;
    }
}
