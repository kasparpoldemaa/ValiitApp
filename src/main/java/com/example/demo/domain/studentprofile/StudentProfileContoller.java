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


    @PutMapping("/id")
    @Operation(summary = "Uuendab student-profile id järgi.")
    public void updateStudentProfile(@RequestParam Integer studentProfileId, @Valid @RequestBody StudentProfileDto studentProfileDto) {
        studentProfileService.updateStudentProfile(studentProfileId, studentProfileDto);
    }

    @DeleteMapping("/id")
    @Operation(summary = "/Kustuta student-profile id järgi")
    public void removeStudentProfileById(@RequestParam Integer id) {
        studentProfileService.removeStudentProfileById(id);
    }

    @GetMapping
    @Operation(summary = "Leiab õpilase profiili studentProfileId järgi.")
    public StudentProfileDto getStudentProfileById(@RequestParam Integer studentProfileId) {
        return studentProfileService.getStudentProfileById(studentProfileId);
    }

//    @PostMapping("/create-empty")
//    @Operation(summary = "Loob tühja profiili")
//    public Integer createEmptyProfile() {
//        return studentProfileService.createEmptyProfile();
//    }

//    @PutMapping("/profileId")
//    @Operation(summary = "Uuendab student-profile'i")
//    public void updateStudentProfile(@Valid @RequestBody StudentProfileDto studentProfileDto) {
//        studentProfileService.updateStudentProfile(studentProfileDto);
//    }
}
