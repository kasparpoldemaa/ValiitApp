package com.example.demo.service.image;

import com.example.demo.domain.picture.PictureService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class ImageController {

        @Resource
        private ImageService imageService;

        @PostMapping("/in")
        @Operation(summary = "Lisab pildi ")
        public void addPicture(@RequestBody ImageRequest request) {
                imageService.addPicture(request);
        }

        @GetMapping("/all")
        @Operation (summary = "Tagastab kõik pildid")
        public List<ImageResponse> getAllPictures (){
                return imageService.getAllPictures();
        }

        @GetMapping("/id")
        @Operation(summary = "Leiab pildi studentId järgi")
        public ImageResponse getPictureByStudentId(Integer studentId) {
                return imageService.getPictureByStudentId(studentId);
        }



}
