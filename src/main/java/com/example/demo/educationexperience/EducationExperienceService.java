package com.example.demo.educationexperience;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EducationExperienceService {

    @Resource
    private EducationExperienceMapper educationExperienceMapper;

    @Resource
    private EducationExperienceRepository educationExperienceRepository;

}
