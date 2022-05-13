package com.example.demo.domain.internshipapplicant;

import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.internshipopportunity.InternshipOpportunity;
import com.example.demo.domain.internshipopportunity.InternshipOppurtunityService;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.user.User;
import com.example.demo.service.applicant.ApplicantResponse;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InternshipApplicantService {

    @Resource
    private InternshipApplicantMapper internshipApplicantMapper;

    @Resource
    private InternshipApplicantRepository internshipApplicantRepository;

    @Resource
    private StudentService studentService;

    @Resource
    private InternshipOppurtunityService internshipOppurtunityService;

    @Resource
    private ValidationService validationService;

    @Resource
    private ContactService contactService;

    public ApplicantResponse addNewApplicant(Integer offerId, Integer studentId, String letter) {
        Student student = studentService.findStudentByStudentId(studentId);
        InternshipOpportunity offer = internshipOppurtunityService.getOfferById(offerId);
        boolean hasApplied = internshipApplicantRepository.existsByOfferIdAndStudentId(offerId, studentId);
        validationService.hasAlreadyApplied(hasApplied);
        InternshipApplicant internshipApplicant = new InternshipApplicant();
        internshipApplicant.setInternshipOpportunity(offer);
        internshipApplicant.setStudent(student);
        internshipApplicant.setMotivationLetter(letter);
        internshipApplicantRepository.save(internshipApplicant);
        return internshipApplicantMapper.toDto(internshipApplicant);
    }

    public Integer getApplicantCount(Integer opportunityId) {
        long longCount = internshipApplicantRepository.countByInternshipOpportunity_Id(opportunityId);
        return Math.toIntExact(longCount);
    }

    public List<Integer> getAppliedStudentIds(Integer id) {
        List<InternshipApplicant> opportunityList = internshipApplicantRepository.getOpportunityList(id);
        ArrayList<Integer> studenIds = new ArrayList<>();
        for (InternshipApplicant internshipApplicant : opportunityList) {
            studenIds.add(internshipApplicant.getStudent().getId());
        }
        return studenIds;
    }

    public List<ApplicantResponse> getApplicantApplications(Integer studentId) {
        List<InternshipApplicant> applicants = internshipApplicantRepository.findByStudentId(studentId);
        List<ApplicantResponse> applicantResponses = internshipApplicantMapper.toDtos(applicants);
        for (ApplicantResponse applicantRespons : applicantResponses) {
            Integer userId = internshipOppurtunityService.getOfferById(applicantRespons.getInternshipOpportunity().getId()).getUser().getId();
            applicantRespons.setCompanyName(contactService.getCompanyNameByUserId(userId));
        }
        return applicantResponses;
    }

    public List<InternshipApplicant> getApplicants(Integer opportunityId) {
        return internshipApplicantRepository.findApplicants(opportunityId);
    }

    public String getApplicantMotivationLetter(Integer internshipOpportunityId, Integer studentId) {
        InternshipApplicant internshipApplicant = internshipApplicantRepository.findByInternshipOpportunityIdAndStudentId(internshipOpportunityId, studentId);
        return internshipApplicant.getMotivationLetter();
    }


//    public InternshipOppurtunityResponse findStundetCountAndId(Integer internshipOppurtunityId) {
//
//        List<InternshipApplicant> internshipApplicants = internshipApplicantRepository.findByInternshipOpportunity_Id(internshipOppurtunityId);
//
//        List<Integer> studentId = new ArrayList<>();
//        Integer count = 0;
//
//        for (InternshipApplicant internshipApplicant : internshipApplicants) {
//            Integer id = internshipApplicant.getStudent().getId();
//
//            studentId.add(id);
//            count++;
//        }
//
//        InternshipOppurtunityResponse internshipOppurtunityResponse = new InternshipOppurtunityResponse();
//        internshipOppurtunityResponse.setStudentId(studentId);
//        internshipOppurtunityResponse.setStudentCount(count);
//
//        return internshipOppurtunityResponse;
//    }
}
