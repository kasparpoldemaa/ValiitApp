package com.example.demo.service.profile;

import com.example.demo.domain.studentprofile.StudentProfileDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Resource
    private ProfileService profileService;

    @GetMapping
    public StudentProfileDto getProfileByUserId(@RequestParam Integer userId) {

        return null;
    }

    @PostMapping
    public void addNewUserProfile(StudentProfileDto profileDto) {
        profileService.addNewUserProfile(profileDto);
    }

}


