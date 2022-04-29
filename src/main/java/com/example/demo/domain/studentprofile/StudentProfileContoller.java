package com.example.demo.domain.studentprofile;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/student-profile")
public class StudentProfileContoller {

    @Resource
    private StudentProfileService studentProfileService;

    @PostMapping("/add")
    @Operation(summary = "Lisab uue student-profile student-id järgi")
    public StudentProfileDto addNewStudentProfile(@RequestBody StudentProfileDto studentProfileDto) {
        return studentProfileService.addNewStudentProfile(studentProfileDto);
    }
//TODO Swaggeris errorid update ja delete meetoditel
    @GetMapping("/update")
    @Operation(summary = "Uuendab student-profile id järgi.")
    public void updateStudentProfile(@RequestParam Integer studentProfileId, @Valid @RequestBody StudentProfileDto studentProfileDto) {
        studentProfileService.updateStudentProfile(studentProfileId, studentProfileDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "/Kustuta student-profile id järgi")
    public void removeStudentProfileById(@RequestParam Integer id) {
        studentProfileService.removeStudentProfileById(id);
    }
}
