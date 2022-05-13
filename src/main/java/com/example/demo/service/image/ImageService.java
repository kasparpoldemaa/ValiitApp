package com.example.demo.service.image;

import com.example.demo.domain.picture.PictureService;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService {
    @Resource
    private PictureService pictureService;

    @Resource
    private ValidationService validationService;

    public Integer addPicture(Integer studentId, ImageRequest request) {
        boolean pictureDataExists = request.getBase64().isEmpty();
        validationService.newPictureExists(pictureDataExists);
        return pictureService.addPicture(studentId, request);
    }

    public List<ImageResponse> getAllPictures() {
        return pictureService.getAllPictures();
    }

    public ImageResponse getPictureById(Integer pictureId) {
        return pictureService.getPictureById(pictureId);
    }

    public ImageResponse findPictureByStudentId(Integer studentId) {
        return pictureService.findPictureByStudentId(studentId);
    }

    public void deleteStudentPicture(Integer studentId) {
        pictureService.deleteStudentPicture(studentId);
    }
}
