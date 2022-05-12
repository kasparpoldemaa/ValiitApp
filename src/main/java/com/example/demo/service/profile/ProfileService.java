package com.example.demo.service.profile;

import com.example.demo.domain.contact.Contact;
import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.internshipapplicant.InternshipApplicant;
import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.studentprofile.StudentProfileDto;
import com.example.demo.domain.studentprofile.StudentProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Resource
    private StudentProfileService studentProfileService;

    @Resource
    private ContactService contactService;

    @Resource
    private StudentService studentService;

    @Resource
    private InternshipApplicantService internshipApplicantService;

    public void addNewUserProfile(StudentProfileDto profileDto) {
        // lisa andmed
            //  student profile
            //  contact
    }





    public List<ApplicantResponse> getAllApplicants(Integer opportunityId) {
        List<InternshipApplicant> applicants = internshipApplicantService.getApplicants(opportunityId);
        List<ApplicantResponse> responses = new ArrayList<>();
        for (InternshipApplicant applicant : applicants) {
            Contact contact = contactService.getContact(applicant.getStudent().getUser().getId());
            ApplicantResponse applicantResponse = new ApplicantResponse();
            applicantResponse.setStudentId(applicant.getStudent().getId());
            applicantResponse.setProfileId(applicant.getStudent().getStudentProfile().getId());
            applicantResponse.setFirstName(contact.getFirstName());
            applicantResponse.setLastName(contact.getLastName());
            responses.add(applicantResponse);
        }
        return responses;



    }

    public StudentProfileDto getProfileByStudentId(Integer studentId) {
        return studentService.getProfileByStudentId(studentId);

    }
}
