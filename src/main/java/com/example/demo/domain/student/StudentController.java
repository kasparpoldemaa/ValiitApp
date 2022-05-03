package com.example.demo.domain.student;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/get-by-availability")
    public List<StudentDto> getAvailableStudents() {
        return studentService.getAvailableStudents();
    }




    @PostMapping("/new")
    @Operation(summary = "Loo uus student")
    public Integer addNewStudent(Integer userId, Integer studentProfileId) {
        return studentService.addNewStudent(userId, studentProfileId);
    }

}
