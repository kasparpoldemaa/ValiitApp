package com.example.demo.domain.student;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "studentProfileId", target = "studentProfile.id")
    Student toEntity(StudentDto studentDto);

    @InheritInverseConfiguration(name = "toEntity")
    StudentDto toDto(Student student);

    List<StudentDto> toDtos(List<Student> students);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromStudentDto(StudentDto studentDto, @MappingTarget Student student);
}
