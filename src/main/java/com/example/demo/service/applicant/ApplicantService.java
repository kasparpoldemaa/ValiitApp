package com.example.demo.service.applicant;

import com.example.demo.domain.contact.Contact;
import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.internshipapplicant.InternshipApplicant;
import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    @Resource
    private InternshipApplicantService internshipApplicantService;

    @Resource
    private StudentService studentService;

    @Resource
    private ContactService contactService;

    public ApplicantResponse addNewApplicant(Integer offerId, Integer studentId, String letter) {
        return internshipApplicantService.addNewApplicant(offerId, studentId, letter);
    }

    public List<ApplicantResponse> getApplicantApplications(Integer studentId) {
        return internshipApplicantService.getApplicantApplications(studentId);
    }

    public String getApplicantMotivationLetter(Integer internshipOpportunityId, Integer studentId) {
        return internshipApplicantService.getApplicantMotivationLetter(internshipOpportunityId, studentId);
    }

    public List<StudentsResponse> getStudentsList() {

        List<Student> students = studentService.getAllStudents();
        List<StudentsResponse> studentsResponses = new ArrayList<>();

        for (Student student : students) {
            Contact contact = contactService.getContactByUserId(student.getUser().getId());
            StudentsResponse studentsResponse = new StudentsResponse();
            studentsResponse.setFirstName(contact.getFirstName());
            studentsResponse.setLastName(contact.getLastName());
            studentsResponse.setLinkedIn(student.getStudentProfile().getLinkedin());
            studentsResponses.add(studentsResponse);
        }
        return studentsResponses;
    }

//    public InternshipOppurtunityResponse getCountAndStudentId(Integer internshipOppurtunityId) {
//        return internshipApplicantService.findStundetCountAndId(internshipOppurtunityId);
//    }
}
