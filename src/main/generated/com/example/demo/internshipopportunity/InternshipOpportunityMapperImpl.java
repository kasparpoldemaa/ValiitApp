package com.example.demo.internshipopportunity;

import com.example.demo.user.User;
import com.example.demo.user.UserDto;
import com.example.demo.workoption.WorkOption;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-29T09:42:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class InternshipOpportunityMapperImpl implements InternshipOpportunityMapper {

    @Override
    public InternshipOpportunity toEntity(InternshipOpportunityDto internshipOpportunityDto) {
        if ( internshipOpportunityDto == null ) {
            return null;
        }

        InternshipOpportunity internshipOpportunity = new InternshipOpportunity();

        internshipOpportunity.setWorkOptions( internshipOpportunityDtoToWorkOption( internshipOpportunityDto ) );
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

    @Override
    public InternshipOpportunityDto toDto(InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunity == null ) {
            return null;
        }

        InternshipOpportunityDto internshipOpportunityDto = new InternshipOpportunityDto();

        internshipOpportunityDto.setWorkOptionsId( internshipOpportunityWorkOptionsId( internshipOpportunity ) );
        internshipOpportunityDto.setWorkOptionsOption( internshipOpportunityWorkOptionsOption( internshipOpportunity ) );
        internshipOpportunityDto.setWorkOptionsDescription( internshipOpportunityWorkOptionsDescription( internshipOpportunity ) );
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

    @Override
    public void updateInternshipOpportunityFromInternshipOpportunityDto(InternshipOpportunityDto internshipOpportunityDto, InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunityDto == null ) {
            return;
        }

        if ( internshipOpportunity.getWorkOptions() == null ) {
            internshipOpportunity.setWorkOptions( new WorkOption() );
        }
        internshipOpportunityDtoToWorkOption1( internshipOpportunityDto, internshipOpportunity.getWorkOptions() );
        if ( internshipOpportunityDto.getId() != null ) {
            internshipOpportunity.setId( internshipOpportunityDto.getId() );
        }
        if ( internshipOpportunityDto.getLocation() != null ) {
            internshipOpportunity.setLocation( internshipOpportunityDto.getLocation() );
        }
        if ( internshipOpportunityDto.getStartTime() != null ) {
            internshipOpportunity.setStartTime( internshipOpportunityDto.getStartTime() );
        }
        if ( internshipOpportunityDto.getDuration() != null ) {
            internshipOpportunity.setDuration( internshipOpportunityDto.getDuration() );
        }
        if ( internshipOpportunityDto.getIsPayable() != null ) {
            internshipOpportunity.setIsPayable( internshipOpportunityDto.getIsPayable() );
        }
        if ( internshipOpportunityDto.getNumberOfPositions() != null ) {
            internshipOpportunity.setNumberOfPositions( internshipOpportunityDto.getNumberOfPositions() );
        }
        if ( internshipOpportunityDto.getComment() != null ) {
            internshipOpportunity.setComment( internshipOpportunityDto.getComment() );
        }
        if ( internshipOpportunityDto.getUser() != null ) {
            if ( internshipOpportunity.getUser() == null ) {
                internshipOpportunity.setUser( new User() );
            }
            userDtoToUser1( internshipOpportunityDto.getUser(), internshipOpportunity.getUser() );
        }
    }

    protected WorkOption internshipOpportunityDtoToWorkOption(InternshipOpportunityDto internshipOpportunityDto) {
        if ( internshipOpportunityDto == null ) {
            return null;
        }

        WorkOption workOption = new WorkOption();

        workOption.setId( internshipOpportunityDto.getWorkOptionsId() );
        workOption.setOption( internshipOpportunityDto.getWorkOptionsOption() );
        workOption.setDescription( internshipOpportunityDto.getWorkOptionsDescription() );

        return workOption;
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

    private Integer internshipOpportunityWorkOptionsId(InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunity == null ) {
            return null;
        }
        WorkOption workOptions = internshipOpportunity.getWorkOptions();
        if ( workOptions == null ) {
            return null;
        }
        Integer id = workOptions.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String internshipOpportunityWorkOptionsOption(InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunity == null ) {
            return null;
        }
        WorkOption workOptions = internshipOpportunity.getWorkOptions();
        if ( workOptions == null ) {
            return null;
        }
        String option = workOptions.getOption();
        if ( option == null ) {
            return null;
        }
        return option;
    }

    private String internshipOpportunityWorkOptionsDescription(InternshipOpportunity internshipOpportunity) {
        if ( internshipOpportunity == null ) {
            return null;
        }
        WorkOption workOptions = internshipOpportunity.getWorkOptions();
        if ( workOptions == null ) {
            return null;
        }
        String description = workOptions.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
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

    protected void internshipOpportunityDtoToWorkOption1(InternshipOpportunityDto internshipOpportunityDto, WorkOption mappingTarget) {
        if ( internshipOpportunityDto == null ) {
            return;
        }

        if ( internshipOpportunityDto.getWorkOptionsId() != null ) {
            mappingTarget.setId( internshipOpportunityDto.getWorkOptionsId() );
        }
        if ( internshipOpportunityDto.getWorkOptionsOption() != null ) {
            mappingTarget.setOption( internshipOpportunityDto.getWorkOptionsOption() );
        }
        if ( internshipOpportunityDto.getWorkOptionsDescription() != null ) {
            mappingTarget.setDescription( internshipOpportunityDto.getWorkOptionsDescription() );
        }
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
}
