package com.example.demo.profile;

import com.example.demo.contact.ContactService;
import com.example.demo.studentprofile.StudentProfileDto;
import com.example.demo.studentprofile.StudentProfileService;
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
