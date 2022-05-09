package com.example.demo.service.applicant;

import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @GetMapping("/all")
    @Operation(summary = "Tagastab studentite objektid ja nende ID-d, kes konkreetsele pakkumisele kandideerisid")
    public InternshipOppurtunityResponse getCountAndStudentId(@RequestParam Integer internshipOppurtunityId) {
        return applicantService.getCountAndStudentId(internshipOppurtunityId);
    }



}
