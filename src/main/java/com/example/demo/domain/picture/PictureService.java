package com.example.demo.domain.picture;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentService;
import com.example.demo.service.image.ImageRequest;
import com.example.demo.service.image.ImageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

    @Resource
    private PictureMapper pictureMapper;

    @Resource
    private StudentService studentService;

    public Integer addPicture(Integer studentId, ImageRequest request) {
        Student student = studentService.findStudentByStudentId(studentId);
//        Integer id = student.getPicture().getId();
//        if (id != null) {
//            pictureRepository.deleteById(id);
//        }
        byte[] data = request.getBase64().getBytes(StandardCharsets.UTF_8);
        Picture picture = new Picture();
        picture.setBase64(data);
        student.setPicture(picture);
        pictureRepository.save(picture);
        return picture.getId();
    }


    public List<ImageResponse> getAllPictures() {
        List<Picture> pictures = pictureRepository.findAll();
        return pictureMapper.toResponses(pictures);
    }

    public ImageResponse getPictureById(Integer pictureId) {
        return pictureMapper.toResponse(pictureRepository.getById(pictureId));
    }

    public ImageResponse findPictureByStudentId(Integer studentId) {
        Student student = studentService.findStudentByStudentId(studentId);
        return pictureMapper.toResponse(student.getPicture());
    }

    public void deleteStudentPicture(Integer studentId) {
        Student student = studentService.findStudentByStudentId(studentId);
        Integer pictureId = student.getPicture().getId();
        student.setPicture(null);
        pictureRepository.deleteById(pictureId);


    }
}
