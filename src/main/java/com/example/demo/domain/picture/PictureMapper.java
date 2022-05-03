package com.example.demo.domain.picture;

import com.example.demo.service.image.ImageResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PictureMapper {
    Picture toEntity(PictureDto pictureDto);

    PictureDto toDto(Picture picture);

    List<ImageResponse> toDtos(List<Picture> pictures);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePictureFromPictureDto(PictureDto pictureDto, @MappingTarget Picture picture);
}
