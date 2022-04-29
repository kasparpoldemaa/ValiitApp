package com.example.demo.educationexperience;

import com.example.demo.workexperience.WorkExperienceDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/education-experience")
public class EducationExperienceController {

    @Resource
    private EducationExperienceService educationExperienceService;


    @PostMapping
    @Operation(summary = "Lisab uue hariduse")
    public EducationExperience addNewEducationExperience(@Valid @RequestBody EducationExperienceDto educationExperienceDto){
        return educationExperienceService.addNewEducationExperience(educationExperienceDto);
    }


    @GetMapping
    @Operation(summary = "Kuvab hariduse id järgi." )
    public EducationExperienceDto getEducationExperienceById(@RequestParam Integer studentId) {
        return educationExperienceService.getEducationExperienceById(studentId);
    }

//    @PutMapping
//    @Operation(summary = "Muudab hariduse id järgi.")
//    public void updateEducationExperienceById(@Valid @RequestBody EducationExperienceDto educationExperienceDto) {
//        educationExperienceService.updateEducationExperienceById(educationExperienceId, educationExperienceDto);
//    }
}
