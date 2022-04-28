package com.example.demo.requiredtechnology;

import com.example.demo.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.technology.TechnologyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredTechnologyDto implements Serializable {
    private Integer id;
    private InternshipOpportunityDto internshipOpportunity;
    private TechnologyDto technology;
}
