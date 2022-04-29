package com.example.demo.workexperience;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-29T09:42:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class WorkExperienceMapperImpl implements WorkExperienceMapper {

    @Override
    public WorkExperience toEntity(WorkExperienceDto workExperienceDto) {
        if ( workExperienceDto == null ) {
            return null;
        }

        WorkExperience workExperience = new WorkExperience();

        workExperience.setStartDate( workExperienceDto.getStartDate() );
        workExperience.setEndDate( workExperienceDto.getEndDate() );
        workExperience.setCompanyName( workExperienceDto.getCompanyName() );
        workExperience.setPosition( workExperienceDto.getPosition() );
        workExperience.setJobDescription( workExperienceDto.getJobDescription() );

        return workExperience;
    }

    @Override
    public WorkExperienceDto toDto(WorkExperience workExperience) {
        if ( workExperience == null ) {
            return null;
        }

        WorkExperienceDto workExperienceDto = new WorkExperienceDto();

        workExperienceDto.setStartDate( workExperience.getStartDate() );
        workExperienceDto.setEndDate( workExperience.getEndDate() );
        workExperienceDto.setCompanyName( workExperience.getCompanyName() );
        workExperienceDto.setPosition( workExperience.getPosition() );
        workExperienceDto.setJobDescription( workExperience.getJobDescription() );

        return workExperienceDto;
    }

    @Override
    public void updateEntity(WorkExperienceDto workExperienceDto, WorkExperience workExperience) {
        if ( workExperienceDto == null ) {
            return;
        }

        if ( workExperienceDto.getStartDate() != null ) {
            workExperience.setStartDate( workExperienceDto.getStartDate() );
        }
        if ( workExperienceDto.getEndDate() != null ) {
            workExperience.setEndDate( workExperienceDto.getEndDate() );
        }
        if ( workExperienceDto.getCompanyName() != null ) {
            workExperience.setCompanyName( workExperienceDto.getCompanyName() );
        }
        if ( workExperienceDto.getPosition() != null ) {
            workExperience.setPosition( workExperienceDto.getPosition() );
        }
        if ( workExperienceDto.getJobDescription() != null ) {
            workExperience.setJobDescription( workExperienceDto.getJobDescription() );
        }
    }
}
