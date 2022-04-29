package com.example.demo.profile;

import com.example.demo.studentprofile.StudentProfileDto;
import com.example.demo.studentprofile.StudentProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Resource
    private ProfileService profileService;

    public StudentProfileDto getProfileByUserId(@RequestParam Integer userId) {

        return null;
    }

    @PostMapping
    public void addNewUserProfile(StudentProfileDto profileDto) {
        profileService.addNewUserProfile(profileDto);
    }

}


