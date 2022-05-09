package com.example.demo.service.applicant;

import com.example.demo.domain.internshipapplicant.InternshipApplicantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ApplicantController {

    @Resource
    private ApplicantService applicantService;

    @PostMapping("/new")
    @Operation(summary = "Lisab uue kandidaadi")
    public ApplicantResponse addNewApplicant (@RequestParam Integer offerId,@RequestParam  Integer studentId,@RequestParam  String letter) {
        return applicantService.addNewApplicant(offerId,studentId,letter);
    }



}
