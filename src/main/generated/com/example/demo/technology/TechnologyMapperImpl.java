package com.example.demo.technology;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T14:47:54+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TechnologyMapperImpl implements TechnologyMapper {

    @Override
    public Technology toEntity(TechnologyDto technologyDto) {
        if ( technologyDto == null ) {
            return null;
        }

        Technology technology = new Technology();

        technology.setId( technologyDto.getId() );
        technology.setName( technologyDto.getName() );

        return technology;
    }

    @Override
    public TechnologyDto toDto(Technology technology) {
        if ( technology == null ) {
            return null;
        }

        TechnologyDto technologyDto = new TechnologyDto();

        technologyDto.setId( technology.getId() );
        technologyDto.setName( technology.getName() );

        return technologyDto;
    }

    @Override
    public void updateTechnologyFromTechnologyDto(TechnologyDto technologyDto, Technology technology) {
        if ( technologyDto == null ) {
            return;
        }

        if ( technologyDto.getId() != null ) {
            technology.setId( technologyDto.getId() );
        }
        if ( technologyDto.getName() != null ) {
            technology.setName( technologyDto.getName() );
        }
    }
}
