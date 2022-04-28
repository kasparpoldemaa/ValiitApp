package com.example.demo.internshipapplicant;

import com.example.demo.internshipopportunity.InternshipOpportunityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InternshipApplicantService {

    @Resource
    private InternshipApplicantMapper internshipApplicantMapper;

    @Resource
    private InternshipOpportunityRepository internshipOpportunityRepository;
}
