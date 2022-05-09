package com.example.demo.domain.internshipopportunity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternshipOpportunityDto implements Serializable {
    private Integer opportunityId;
    private String location;
    private String startTime;
    private String duration;
    private Boolean isPayable = false;
    private String numberOfPositions;
    private String comment;
    private String companyName;
//    private Integer userId;
    private String technology;
    private String workType;
    private Integer interestedCount;
}
