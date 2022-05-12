package com.example.demo.service.profile;

import com.example.demo.domain.studentprofile.StudentProfileDto;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Resource
    private ProfileService profileService;

    @GetMapping ("/id")
    public StudentProfileDto getProfileByStudentId(@RequestParam Integer studentId) {
        return profileService.getProfileByStudentId(studentId);
    }

    @PostMapping
    public void addNewUserProfile(StudentProfileDto profileDto) {
        profileService.addNewUserProfile(profileDto);
    }



    @GetMapping("/all-applicants")
    @Operation(summary = "Kuvab studenti nime ja studentID, opportunityId järgi")
    public List<ApplicantResponse> getAllApplicants(@RequestParam Integer opportunityId) {
        return profileService.getAllApplicants(opportunityId);
    }



}


