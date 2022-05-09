package com.example.demo.service.applicant;

import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplicantService {

    @Resource
    private InternshipApplicantService internshipApplicantService;

    public ApplicantResponse addNewApplicant(Integer offerId, Integer studentId, String letter) {
        return internshipApplicantService.addNewApplicant(offerId, studentId, letter);
    }

    public InternshipOppurtunityResponse getCountAndStudentId(Integer internshipOppurtunityId) {
        return internshipApplicantService.findStundetCountAndId(internshipOppurtunityId);
    }
}
