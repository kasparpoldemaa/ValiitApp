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
    @Operation(summary = "Loob uue student-profile")
    public StudentProfileDto addNewStudentProfile(@RequestBody StudentProfileDto studentProfileDto) {
        return studentProfileService.addNewStudentProfile(studentProfileDto);
    }


    @PutMapping("/update")
    @Operation(summary = "Uuendab student-profile id järgi.")
    public void updateStudentProfile(@RequestParam Integer studentProfileId, @Valid @RequestBody StudentProfileDto studentProfileDto) {
        studentProfileService.updateStudentProfile(studentProfileId, studentProfileDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "/Kustuta student-profile id järgi")
    public void removeStudentProfileById(@RequestParam Integer id) {
        studentProfileService.removeStudentProfileById(id);
    }

    @PostMapping("/create-empty")
    @Operation(summary = "Loob tühja profiili")
    public Integer createEmptyProfile() {
        return studentProfileService.createEmptyProfile();
    }
}
