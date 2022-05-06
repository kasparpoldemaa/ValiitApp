package com.example.demo.service.company;

import com.example.demo.domain.internshipopportunity.InternshipOpportunityDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;


    @PostMapping("/new-internship")
    @Operation(summary = "Lisab uue praktika pakkumise")
    public CompanyResponse addNewInternship(@RequestParam Boolean isPayable, @RequestParam Integer userId, @Valid @RequestBody InternshipOpportunityDto dto) {
        return companyService.addNewInternship(isPayable, userId, dto);
    }

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik sisesttatud praktika avaldused user ID järgi")
    public List<InternshipOpportunityDto> getAllOffersByUserId(@RequestParam Integer userId) {
        return companyService.getAllOffersByUserId(userId);
    }


    @DeleteMapping("/remove")
    @Operation(summary = "Kustutab praktika avalduse id järgi ")
    public void removeById(Integer id) {
        companyService.removeById(id);
    }
}
