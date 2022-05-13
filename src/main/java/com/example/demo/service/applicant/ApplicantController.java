package com.example.demo.service.applicant;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Resource
    private ApplicantService applicantService;

    @PostMapping("/new")
    @Operation(summary = "Lisab uue kandidaadi")
    public ApplicantResponse addNewApplicant (@RequestParam Integer offerId,@RequestParam  Integer studentId,@RequestParam  String letter) {
        return applicantService.addNewApplicant(offerId,studentId,letter);
    }

    @GetMapping("/student-id")
    @Operation(summary = "Leiab ühe õpilase kõik kandideerimised")
    public List<ApplicantResponse> getApplicantApplications(@RequestParam Integer studentId) {
        return applicantService.getApplicantApplications(studentId);
    }

    @GetMapping("/letter")
    @Operation(summary = "Leiab õpilase motivatsioonikirja")
    public String getApplicantMotivationLetter(@RequestParam Integer internshipOpportunityId, @RequestParam Integer studentId) {
        return applicantService.getApplicantMotivationLetter(internshipOpportunityId, studentId);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab listi kõikide õpialste nimedest ja linkedIn kontost")

    public List<StudentsResponse> getStudentsList() {
        return applicantService.getStudentsList();
    }


//    @GetMapping("/all")
//    @Operation(summary = "Tagastab studentite objektid ja nende ID-d, kes konkreetsele pakkumisele kandideerisid")
//    public InternshipOppurtunityResponse getCountAndStudentId(@RequestParam Integer internshipOppurtunityId) {
//        return applicantService.getCountAndStudentId(internshipOppurtunityId);
//    }



}
