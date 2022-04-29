package com.example.demo.service.profile;

import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.studentprofile.StudentProfileDto;
import com.example.demo.domain.studentprofile.StudentProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProfileService {

    @Resource
    private StudentProfileService studentProfileService;
    @Resource
    private ContactService contactService;

    public void addNewUserProfile(StudentProfileDto profileDto) {
        // lisa andmed
            //  student profile
            //  contact
    }
}
