package com.example.demo.educationexperience;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/education-experience")
public class EducationExperienceController {

    @Resource
    private EducationExperienceService educationExperienceService;
}