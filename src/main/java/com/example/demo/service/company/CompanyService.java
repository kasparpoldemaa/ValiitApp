package com.example.demo.service.company;

import com.example.demo.domain.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.domain.internshipopportunity.InternshipOppurtunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyService {


    @Resource
    private InternshipOppurtunityService internshipOppurtunityService;

    public CompanyResponse addNewInternship(Boolean isPayable, Integer userId,InternshipOpportunityDto dto) {
        CompanyResponse companyResponse = internshipOppurtunityService.addNewInternship(isPayable, userId,dto);
        return companyResponse;
    }
}
