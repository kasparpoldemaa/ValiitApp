package com.example.demo.workexperience;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkExperienceService {

    @Resource
    private WorkExperienceMapper workExperienceMapper;

    @Resource
    private WorkExperienceRepository workExperienceRepository;

}
