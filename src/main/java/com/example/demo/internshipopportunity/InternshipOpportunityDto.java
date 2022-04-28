package com.example.demo.internshipopportunity;

import com.example.demo.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipOpportunityDto implements Serializable {
    private Integer id;
    private Integer workOptionsId;
    private String workOptionsOption;
    private String workOptionsDescription;
    private String location;
    private String startTime;
    private String duration;
    private Boolean isPayable;
    private String numberOfPositions;
    private String comment;
    private UserDto user;
}
