package com.example.demo.domain.workexperience;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/work-experience")
public class WorkExperienceController {

    @Resource
    private WorkExperienceService workExperienceService;


    @PostMapping("/add")
    @Operation(summary= "Lisab uue töökogemuse.")
    public WorkExperienceDto addNewWorkExperience(@RequestParam Integer studentId, @Valid @RequestBody WorkExperienceDto workExperienceDto){
        return workExperienceService.addNewWorkExperience(studentId, workExperienceDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab õpilase id järgi töökogemused")
    public WorkExperienceDto getWorkExperienceById(@RequestParam Integer studentId){
        return workExperienceService.getWorkExperienceById(studentId);
    }

    @PutMapping("/update")
    @Operation(summary = "Uuendab töökogemuse id järgi" )
    public void updateWorkExperienceById(@RequestParam Integer workExperienceId, @Valid @RequestBody WorkExperienceDto workExperienceDto) {
        workExperienceService.updateWorkExperienceById(workExperienceId, workExperienceDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Kustuta töökogemus id järgi")
    public void removeWorkExperienceById(@RequestParam Integer workExperienceId) {
        workExperienceService.removeWorkExperienceById(workExperienceId);
    }



}
