package com.example.demo.domain.studentprofile;

import com.example.demo.domain.student.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentProfileService {

    @Resource
    private StudentRepository studentRepository;

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
}
