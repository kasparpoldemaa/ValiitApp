package com.example.demo.service.applicant;

import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplicantService {

    @Resource
    private InternshipApplicantService internshipApplicantService;

    public ApplicantResponse addNewApplicant(Integer offerId, Integer studentId, String letter) {
        return internshipApplicantService.addNewApplicant(offerId, studentId, letter);
    }

    public List<ApplicantResponse> getApplicantApplications(Integer studentId) {
        return internshipApplicantService.getApplicantApplications(studentId);
    }

    public String getApplicantMotivationLetter(Integer internshipOpportunityId, Integer studentId) {
        return internshipApplicantService.getApplicantMotivationLetter(internshipOpportunityId, studentId);
    }

//    public InternshipOppurtunityResponse getCountAndStudentId(Integer internshipOppurtunityId) {
//        return internshipApplicantService.findStundetCountAndId(internshipOppurtunityId);
//    }
}
