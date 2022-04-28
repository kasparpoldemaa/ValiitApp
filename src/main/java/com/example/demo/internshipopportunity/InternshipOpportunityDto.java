package com.example.demo.internshipopportunity;

import com.example.demo.user.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class InternshipOpportunityDto implements Serializable {
    private final Integer id;
    private final Integer workOptionsId;
    private final String workOptionsOption;
    private final String workOptionsDescription;
    private final String location;
    private final String startTime;
    private final String duration;
    private final Boolean isPayable;
    private final String numberOfPositions;
    private final String comment;
    private final UserDto user;
}
