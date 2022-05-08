package com.example.demo.domain.educationexperience;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/education-experience")
public class EducationExperienceController {

    @Resource
    private EducationExperienceService educationExperienceService;


    @PostMapping("/add")
    @Operation(summary = "Lisab uue hariduse id järgi.")
    public EducationExperienceDto addNewEducationExperience(@RequestParam Integer studentId, @Valid @RequestBody EducationExperienceDto educationExperienceDto){
        return educationExperienceService.addNewEducationExperience(studentId, educationExperienceDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik haridused student id järgi." )
    public List<EducationExperienceDto> getAllEducationExperienceById(@RequestParam Integer studentId) {
        return educationExperienceService.getAllEducationExperienceById(studentId);
    }

    @PutMapping("/update")
    @Operation(summary = "Uuendab hariduse experience-id järgi.")
    public void updateEducationExperienceById(@RequestParam Integer educationExperienceId, @Valid @RequestBody EducationExperienceDto educationExperienceDto) {
        educationExperienceService.updateEducationExperienceById(educationExperienceId, educationExperienceDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "/Kustutab hariduse id järgi.")
    public void removeEducationById(@RequestParam Integer educationExperienceId) {
        educationExperienceService.removeEducationById(educationExperienceId);
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab konkreetse hariduse id järgi")
    public EducationExperienceDto getEducationExperienceById(@RequestParam Integer educationExperienceId) {
        return educationExperienceService.getEducationExperienceById(educationExperienceId);
    }

}
