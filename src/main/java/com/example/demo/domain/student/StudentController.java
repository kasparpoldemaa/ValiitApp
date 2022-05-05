package com.example.demo.domain.student;

import com.example.demo.service.image.ImageResponse;
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
    @Operation(summary = "Tagastab tudengi saadavuse alusel")
    public List<StudentDto> getAvailableStudents() {
        return studentService.getAvailableStudents();
    }

    @PutMapping("/id")
    @Operation(summary = "Muudab õpilase saadavuse alusel")
    public void setIsStudentAvailableByStudentId(@RequestParam Integer studentId, @RequestParam Boolean isAvailable) {
        studentService.setIsStudentAvailableByStudentId(studentId, isAvailable);
    }


    @PostMapping("/new")
    @Operation(summary = "Loo uus student")
    public Integer addNewStudent(Integer userId, Integer studentProfileId) {
        return studentService.addNewStudent(userId, studentProfileId);
    }



}
