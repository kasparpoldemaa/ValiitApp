package com.example.demo.domain.picture;

import com.example.demo.service.picture.PictureRequest;
import com.example.demo.service.profile.ProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

//
//    public void saveImage(PictureRequest request) {
//        Picture picture = createImage(request);
//        pictureRepository.save(picture);
//
//        User user = Service.findUserByUserId(request.getUserId());
//
//
//
//    }
//
//    private Picture createImage(PictureRequest pictureRequest) {
//        byte[] byteBase64 = pictureRequest.getBase64().getBytes(StandardCharsets.UTF_8);
//        Picture picture = new Picture();
//        picture.setBase64(byteBase64);
//        return picture;
//    }

}
