package com.example.demo.requiredtechnology;

import com.example.demo.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.technology.TechnologyDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class RequiredTechnologyDto implements Serializable {
    private final Integer id;
    private final InternshipOpportunityDto internshipOpportunity;
    private final TechnologyDto technology;
}
