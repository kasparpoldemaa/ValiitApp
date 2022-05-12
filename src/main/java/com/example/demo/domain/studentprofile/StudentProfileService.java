package com.example.demo.domain.studentprofile;

import com.example.demo.service.register.NewUserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentProfileService {


    @Resource
    private StudentProfileMapper studentProfileMapper;

    @Resource
    private StudentProfileRepository studentProfileRepository;

    public StudentProfileDto addNewStudentProfile(StudentProfileDto studentProfileDto) {
        StudentProfile studentProfile = studentProfileMapper.toEntity(studentProfileDto);
        studentProfileRepository.save(studentProfile);
        return studentProfileMapper.toDto(studentProfile);
    }

    public void updateStudentProfile(Integer studentProfileId, StudentProfileDto studentProfileDto) {
        StudentProfile studentProfile = studentProfileRepository.getById(studentProfileId);
        studentProfileMapper.updateEntity(studentProfileDto, studentProfile);
        studentProfileRepository.save(studentProfile);
    }

    public void removeStudentProfileById(Integer id) {
        studentProfileRepository.deleteById(id);
    }

    public StudentProfileDto getStudentProfileById(Integer studentProfileId) {
        StudentProfile studentProfile = studentProfileRepository.getById(studentProfileId);
        return studentProfileMapper.toDto(studentProfile);
    }


    public Integer createEmptyProfile() {
        StudentProfile studentProfile = new StudentProfile();
        studentProfileRepository.save(studentProfile);
        return studentProfile.getId();
    }

    public StudentProfile findStudentProfileById(Integer studentProfileId) {
        return studentProfileRepository.getById(studentProfileId);
    }

    public Integer addEmptyStudentProfile(NewUserRequest request) {
        StudentProfile studentProfile = new StudentProfile();
        studentProfileRepository.save(studentProfile);
        return studentProfile.getId();
    }

    public StudentProfileDto getProfileByProfileId(Integer id) {
        return studentProfileMapper.toDto(studentProfileRepository.getById(id));
    }


//    public void updateStudentProfile(StudentProfileDto studentProfileDto) {
//        StudentProfile byId = studentProfileRepository.getById(studentProfileDto.getId());
//        studentProfileMapper.updateEntity(studentProfileDto, byId);
//        studentProfileRepository.save(byId);
//    }
}


