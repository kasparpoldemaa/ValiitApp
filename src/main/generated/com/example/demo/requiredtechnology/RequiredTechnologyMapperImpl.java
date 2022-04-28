package com.example.demo.requiredtechnology;

import com.example.demo.internshipopportunity.InternshipOpportunity;
import com.example.demo.internshipopportunity.InternshipOpportunityDto;
import com.example.demo.technology.Technology;
import com.example.demo.technology.TechnologyDto;
import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T14:47:54+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class RequiredTechnologyMapperImpl implements RequiredTechnologyMapper {

    @Override
    public RequiredTechnology toEntity(RequiredTechnologyDto requiredTechnologyDto) {
        if ( requiredTechnologyDto == null ) {
            return null;
        }

        RequiredTechnology requiredTechnology = new RequiredTechnology();

        requiredTechnology.setId( requiredTechnologyDto.getId() );
        requiredTechnology.setInternshipOpportunity( internshipOpportunityDtoToInternshipOpportunity( requiredTechnologyDto.getInternshipOpportunity() ) );
        requiredTechnology.setTechnology( technologyDtoToTechnology( requiredTechnologyDto.getTechnology() ) );

        return requiredTechnology;
    }

    @Override
    public RequiredTechnologyDto toDto(RequiredTechnology requiredTechnology) {
        if ( requiredTechnology == null ) {
            return null;
        }

        RequiredTechnologyDto requiredTechnologyDto = new RequiredTechnologyDto();

        requiredTechnologyDto.setId( requiredTechnology.getId() );
        requiredTechnologyDto.setInternshipOpportunity( internshipOpportunityToInternshipOpportunityDto( requiredTechnology.getInternshipOpportunity() ) );
        requiredTechnologyDto.setTechnology( technologyToTechnologyDto( requiredTechnology.getTechnology() ) );

        return requiredTechnologyDto;
    }

    @Override
    public void updateRequiredTechnologyFromRequiredTechnologyDto(RequiredTechnologyDto requiredTechnologyDto, RequiredTechnology requiredTechnology) {
        if ( requiredTechnologyDto == null ) {
            return;
        }

        if ( requiredTechnologyDto.getId() != null ) {
            requiredTechnology.setId( requiredTechnologyDto.getId() );
        }
        if ( requiredTechnologyDto.getInternshipOpportunity() != null ) {
            if ( requiredTechnology.getInternshipOpportunity() == null ) {
                requiredTechnology.setInternshipOpportunity( new InternshipOpportunity() );
            }
            internshipOpportunityDtoToInternshipOpportunity1( requiredTechnologyDto.getInternshipOpportunity(), requiredTechnology.getInternshipOpportunity() );
        }
        if ( requiredTechnologyDto.getTechnology() != null ) {
            if ( requiredTechnology.getTechnology() == null ) {
                requiredTechnology.setTechnology( new Technology() );
            }
            technologyDtoToTechnology1( requiredTechnologyDto.getTechnology(), requiredTechnology.getTechnology() );
        }
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    protected InternshipOpportunity internshipOpportunityDtoToInternshipOpportunity(InternshipOpportunityDto internshipOpportunityDto) {
        if ( internshipOpportunityDto == null ) {
            return null;
        }

        InternshipOpportunity internshipOpportunity = new InternshipOpportunity();

        internshipOpportunity.setId( internshipOpportunityDto.getId() );
        internshipOpportunity.setLocation( internshipOpportunityDto.getLocation() );
        internshipOpportunity.setStartTime( internshipOpportunityDto.getStartTime() );
        internshipOpportunity.setDuration( internshipOpportunityDto.getDuration() );
        internshipOpportunity.setIsPayable( internshipOpportunityDto.getIsPayable() );
        internshipOpportunity.setNumberOfPositions( internshipOpportunityDto.getNumberOfPositions() );
        internshipOpportunity.setComment( internshipOpportunityDto.getComment() );
        internshipOpportunity.setUser( userDtoToUser( internshipOpportunityDto.getUser() ) );

        return internshipOpportunity;
    }

    protected Technology technologyDtoToTechnology(TechnologyDto technologyDto) {
        if ( technologyDto == null ) {
            return null;
        }

        Technology technology = new Technology();

        technology.setId( technologyDto.getId() );
        technology.setName( technologyDto.getName() );

        return technology;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUserName( user.getUserName() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    protected InternshipOpportunityDto internshipOpportunityToInternshipOpportunityDto(InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunity == null ) {
            return null;
        }

        InternshipOpportunityDto internshipOpportunityDto = new InternshipOpportunityDto();

        internshipOpportunityDto.setId( internshipOpportunity.getId() );
        internshipOpportunityDto.setLocation( internshipOpportunity.getLocation() );
        internshipOpportunityDto.setStartTime( internshipOpportunity.getStartTime() );
        internshipOpportunityDto.setDuration( internshipOpportunity.getDuration() );
        internshipOpportunityDto.setIsPayable( internshipOpportunity.getIsPayable() );
        internshipOpportunityDto.setNumberOfPositions( internshipOpportunity.getNumberOfPositions() );
        internshipOpportunityDto.setComment( internshipOpportunity.getComment() );
        internshipOpportunityDto.setUser( userToUserDto( internshipOpportunity.getUser() ) );

        return internshipOpportunityDto;
    }

    protected TechnologyDto technologyToTechnologyDto(Technology technology) {
        if ( technology == null ) {
            return null;
        }

        TechnologyDto technologyDto = new TechnologyDto();

        technologyDto.setId( technology.getId() );
        technologyDto.setName( technology.getName() );

        return technologyDto;
    }

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        if ( userDto.getId() != null ) {
            mappingTarget.setId( userDto.getId() );
        }
        if ( userDto.getUserName() != null ) {
            mappingTarget.setUserName( userDto.getUserName() );
        }
        if ( userDto.getPassword() != null ) {
            mappingTarget.setPassword( userDto.getPassword() );
        }
    }

    protected void internshipOpportunityDtoToInternshipOpportunity1(InternshipOpportunityDto internshipOpportunityDto, InternshipOpportunity mappingTarget) {
        if ( internshipOpportunityDto == null ) {
            return;
        }

        if ( internshipOpportunityDto.getId() != null ) {
            mappingTarget.setId( internshipOpportunityDto.getId() );
        }
        if ( internshipOpportunityDto.getLocation() != null ) {
            mappingTarget.setLocation( internshipOpportunityDto.getLocation() );
        }
        if ( internshipOpportunityDto.getStartTime() != null ) {
            mappingTarget.setStartTime( internshipOpportunityDto.getStartTime() );
        }
        if ( internshipOpportunityDto.getDuration() != null ) {
            mappingTarget.setDuration( internshipOpportunityDto.getDuration() );
        }
        if ( internshipOpportunityDto.getIsPayable() != null ) {
            mappingTarget.setIsPayable( internshipOpportunityDto.getIsPayable() );
        }
        if ( internshipOpportunityDto.getNumberOfPositions() != null ) {
            mappingTarget.setNumberOfPositions( internshipOpportunityDto.getNumberOfPositions() );
        }
        if ( internshipOpportunityDto.getComment() != null ) {
            mappingTarget.setComment( internshipOpportunityDto.getComment() );
        }
        if ( internshipOpportunityDto.getUser() != null ) {
            if ( mappingTarget.getUser() == null ) {
                mappingTarget.setUser( new User() );
            }
            userDtoToUser1( internshipOpportunityDto.getUser(), mappingTarget.getUser() );
        }
    }

    protected void technologyDtoToTechnology1(TechnologyDto technologyDto, Technology mappingTarget) {
        if ( technologyDto == null ) {
            return;
        }

        if ( technologyDto.getId() != null ) {
            mappingTarget.setId( technologyDto.getId() );
        }
        if ( technologyDto.getName() != null ) {
            mappingTarget.setName( technologyDto.getName() );
        }
    }
}
