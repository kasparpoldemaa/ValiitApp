package com.example.demo.domain.student;

import com.example.demo.domain.studentprofile.StudentProfile;
import com.example.demo.domain.studentprofile.StudentProfileService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.service.register.NewUserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StudentProfileService studentProfileService;

    @Resource
    private UserService userService;



    public List<StudentDto> getAvailableStudents() {
        List<Student> students = studentRepository.findByIsAvailable(true);
        return studentMapper.toDtos(students);
    }

    public void setProfileToStudent(Integer studentId, Integer studentProfileId) {
        Student student = findStudentByStudentId(studentId);
        student.setStudentProfile(studentProfileService.getStudentProfileById(studentProfileId));
    }

    public Student findStudentByStudentId(Integer studentId) {
        return studentRepository.getById(studentId);
    }

    public Integer addNewStudent(Integer userId, Integer studentProfileId) {
        User user = userService.findUserByUserId(userId);
        StudentProfile studentProfileById = studentProfileService.findStudentProfileById(studentProfileId);
        Student student = new Student();
        student.setUser(user);
        student.setStudentProfile(studentProfileById);
        student.setIsAvailable(true);
        studentRepository.save(student);
        return student.getId();

//        Student student = studentMapper.toEntity(studentDto);
//        studentRepository.save(student);
//        return student.getId();
    }

    public Integer addNewStudentAtRegister(Integer userId, Integer studentProfileId, NewUserRequest request) {
        User user = userService.findUserByUserId(userId);
        StudentProfile studentProfileById = studentProfileService.findStudentProfileById(studentProfileId);

        Student student = new Student();
        student.setIsAvailable(true);
        student.setUser(user);
        student.setStudentProfile(studentProfileById);
        studentRepository.save(student);

        return student.getId();
    }

    public Integer getStudentIdByUser(Integer id) {
        Student student = studentRepository.findByUser_Id(id);
        return student.getId();
    }

    public StudentResponse getStudentByUser(Integer id) {
        Student student = studentRepository.findByUser_Id(id);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentProfileId(student.getStudentProfile().getId());
        studentResponse.setId(student.getId());

        return studentResponse;
    }


//

}
