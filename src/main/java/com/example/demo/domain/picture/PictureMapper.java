package com.example.demo.domain.picture;

import com.example.demo.service.image.ImageRequest;
import com.example.demo.service.image.ImageResponse;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PictureMapper {

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "base64", source = "base64", qualifiedByName = "byteToString")
    ImageResponse toResponse(Picture picture);

    List<ImageResponse> toResponses(List<Picture> pictures);

    @Named("byteToString")
    static String byteToString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
