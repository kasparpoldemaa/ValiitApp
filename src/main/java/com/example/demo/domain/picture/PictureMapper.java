package com.example.demo.domain.picture;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PictureMapper {
    Picture toEntity(PictureDto pictureDto);

    PictureDto toDto(Picture picture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePictureFromPictureDto(PictureDto pictureDto, @MappingTarget Picture picture);
}
