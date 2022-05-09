package com.example.demo.domain.internshipapplicant;

import com.example.demo.domain.internshipopportunity.InternshipOpportunity;
import com.example.demo.domain.internshipopportunity.InternshipOpportunityRepository;
import com.example.demo.domain.internshipopportunity.InternshipOppurtunityService;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentService;
import com.example.demo.service.applicant.ApplicantResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public ApplicantResponse addNewApplicant(Integer offerId, Integer studentId, String letter) {
        Student student = studentService.findStudentByStudentId(studentId);
        InternshipOpportunity offer = internshipOppurtunityService.getOfferById(offerId);
        InternshipApplicant internshipApplicant = new InternshipApplicant();
        internshipApplicant.setInternshipOpportunity(offer);
        internshipApplicant.setStudent(student);
        internshipApplicant.setMotivationLetter(letter);
        internshipApplicantRepository.save(internshipApplicant);
        return internshipApplicantMapper.toDto(internshipApplicant);
    }
}
