package com.example.demo.domain.internshipopportunity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternshipOpportunityDto implements Serializable {
    private Integer id;
    private String location;
    private String startTime;
    private String duration;
//    private Boolean isPayable;
    private String numberOfPositions;
    private String comment;
//    private Integer userId;
    private String technology;
    private String workType;
}
