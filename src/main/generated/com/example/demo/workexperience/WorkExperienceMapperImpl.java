package com.example.demo.workexperience;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T15:25:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class WorkExperienceMapperImpl implements WorkExperienceMapper {

    @Override
    public WorkExperience toEntity(WorkExperienceDto dto) {
        if ( dto == null ) {
            return null;
        }

        WorkExperience workExperience = new WorkExperience();

        workExperience.setStartDate( dto.getStartDate() );
        workExperience.setEndDate( dto.getEndDate() );
        workExperience.setCompanyName( dto.getCompanyName() );
        workExperience.setPosition( dto.getPosition() );
        workExperience.setJobDescription( dto.getJobDescription() );

        return workExperience;
    }

    @Override
    public WorkExperienceDto toDto(WorkExperience entity) {
        if ( entity == null ) {
            return null;
        }

        WorkExperienceDto workExperienceDto = new WorkExperienceDto();

        workExperienceDto.setStartDate( entity.getStartDate() );
        workExperienceDto.setEndDate( entity.getEndDate() );
        workExperienceDto.setCompanyName( entity.getCompanyName() );
        workExperienceDto.setPosition( entity.getPosition() );
        workExperienceDto.setJobDescription( entity.getJobDescription() );

        return workExperienceDto;
    }

    @Override
    public void updateEntity(WorkExperienceDto dto, WorkExperience workExperience) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getStartDate() != null ) {
            workExperience.setStartDate( dto.getStartDate() );
        }
        if ( dto.getEndDate() != null ) {
            workExperience.setEndDate( dto.getEndDate() );
        }
        if ( dto.getCompanyName() != null ) {
            workExperience.setCompanyName( dto.getCompanyName() );
        }
        if ( dto.getPosition() != null ) {
            workExperience.setPosition( dto.getPosition() );
        }
        if ( dto.getJobDescription() != null ) {
            workExperience.setJobDescription( dto.getJobDescription() );
        }
    }
}
