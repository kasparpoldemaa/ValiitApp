package com.example.demo.service.login;

import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.student.StudentResponse;
import com.example.demo.domain.student.StudentService;
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

    @Resource
    private ContactService contactService;

    @Resource
    private StudentService studentService;

    public LoginResponse logIn(String userName, String password) {
        User user = userService.findUserByNameAndPassword(userName, password);
        UserRole userRole = userRoleService.getUserRoleByUserName(userName);
        Integer contactId = contactService.getContactIdByUser(user.getId());

        if (userRole.getRole().getId() == 2) {
            StudentResponse studentResponse = studentService.getStudentByUser(user.getId());

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setRoleId(userRole.getRole().getId());
            loginResponse.setUserId(user.getId());
            loginResponse.setContactId(contactId);
            loginResponse.setStudentId(studentResponse.getId());
            loginResponse.setStudentProfileId(studentResponse.getStudentProfileId());

            return loginResponse;

        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setRoleId(userRole.getRole().getId());
            loginResponse.setUserId(user.getId());
            loginResponse.setContactId(contactId);

            return loginResponse;
        }

    }
}
