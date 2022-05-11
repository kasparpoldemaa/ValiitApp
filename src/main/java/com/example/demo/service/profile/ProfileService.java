package com.example.demo.service.profile;

import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.studentprofile.StudentProfileDto;
import com.example.demo.domain.studentprofile.StudentProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProfileService {

    @Resource
    private StudentProfileService studentProfileService;

    @Resource
    private ContactService contactService;

    @Resource
    private StudentService studentService;

    public void addNewUserProfile(StudentProfileDto profileDto) {
        // lisa andmed
            //  student profile
            //  contact
    }

    public List<StudentName> getListOfStudentProfiles(List<Integer> studentIds) {
        return studentService.getStudents(studentIds);
    }

    public List<ApplicantResponse> getAllApplicants(Integer opportunityId) {
        return null;
    }
}
