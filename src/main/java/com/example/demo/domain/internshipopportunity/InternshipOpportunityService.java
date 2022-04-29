package com.example.demo.domain.internshipopportunity;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InternshipOpportunityService {

    @Resource
    private InternshipOpportunityMapper internshipOpportunityMapper;

    @Resource
    private InternshipOpportunityRepository internshipOpportunityRepository;
}
