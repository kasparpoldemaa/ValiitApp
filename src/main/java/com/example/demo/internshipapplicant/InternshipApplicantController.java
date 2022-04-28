package com.example.demo.internshipapplicant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/internship-application")
public class InternshipApplicantController {

    @Resource
    private InternshipApplicantService internshipApplicantService;
}
