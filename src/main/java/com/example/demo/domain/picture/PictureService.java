package com.example.demo.domain.picture;

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

    public void addPicture(ImageRequest request) {

        //TODO lisa uus pilt ja seo studentId'ga
//        byte[] data = request.getBase64().getBytes(StandardCharsets.UTF_8);
        Picture picture = new Picture();
//        picture.setBase64(data);
        pictureRepository.save(picture);
    }


    public List<ImageResponse> getAllPictures() {
        List<Picture> pictures = pictureRepository.findAll();
        return pictureMapper.toDtos(pictures);
    }
}
