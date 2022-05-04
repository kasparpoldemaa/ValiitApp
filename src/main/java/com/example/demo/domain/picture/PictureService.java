package com.example.demo.domain.picture;

import com.example.demo.domain.student.StudentService;
import com.example.demo.service.image.ImageRequest;
import com.example.demo.service.image.ImageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

    @Resource
    private PictureMapper pictureMapper;

    @Resource
    private StudentService studentService;

    public void addPicture(ImageRequest request) {
        if(pictureRepository.existsByStudentId(request.getStudentId())){
            Picture picture = pictureRepository.findByStudentId(request.getStudentId());
            pictureRepository.delete(picture);
        }
        byte[] data = request.getBase64().getBytes(StandardCharsets.UTF_8);
        Picture picture = new Picture();
        picture.setBase64(data);
        picture.setStudent(studentService.findStudentByStudentId(request.getStudentId()));
        pictureRepository.save(picture);
    }


    public List<ImageResponse> getAllPictures() {
        List<Picture> pictures = pictureRepository.findAll();
        return pictureMapper.toResponses(pictures);
    }

    public ImageResponse getPictureByStudentId(Integer studentId) {
        return pictureMapper.toResponse(pictureRepository.findByStudentId(studentId));
    }
}
