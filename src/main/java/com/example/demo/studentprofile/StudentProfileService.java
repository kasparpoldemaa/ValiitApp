package com.example.demo.studentprofile;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentProfileService {

    @Resource
    private StudentProfileMapper studentProfileMapper;

    @Resource
    private StudentProfileRepository studentProfileRepository;

}
