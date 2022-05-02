package com.example.demo.domain.student;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentRepository studentRepository;

    public List<StudentDto> getAvailableStudents() {
        List<Student> students = studentRepository.findByIsAvailable(true);
        return studentMapper.toDtos(students);
    }
}
