package com.example.demo.service.image;

import com.example.demo.domain.picture.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService {
    @Resource
    private PictureService pictureService;

    public void addPicture(ImageRequest request) {
        //TODO otsi student ID järgi kas pilt on olemas, kui jah, siis asenda uuega
        pictureService.addPicture(request);
    }

    public List<ImageResponse> getAllPictures() {
        return pictureService.getAllPictures();
    }

    public ImageResponse getPictureByStudentId(Integer studentId) {
        return pictureService.getPictureByStudentId(studentId);
    }
}
