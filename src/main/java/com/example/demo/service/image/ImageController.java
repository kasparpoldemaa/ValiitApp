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
        public Integer addPicture(@RequestParam Integer studentId, @RequestBody ImageRequest request) {
               return imageService.addPicture(studentId, request);
        }

        @GetMapping("/all")
        @Operation (summary = "Tagastab kõik pildid")
        public List<ImageResponse> getAllPictures (){
                return imageService.getAllPictures();
        }

        @GetMapping("/id")
        @Operation(summary = "Leiab pildi id")
        public ImageResponse getPictureById(Integer pictureId) {
                return imageService.getPictureById(pictureId);
        }

        @GetMapping("/student")
        @Operation(summary = "Leiab pildi studentId põhjal")
        public ImageResponse getStudentPicture(Integer studentId) {
                return imageService.findPictureByStudentId(studentId);
        }


        @DeleteMapping("/student")
        @Operation (summary = "Eemaldab pildi studentId põhjal")
        public void deleteStudentPicture(Integer studentId) {
                imageService.deleteStudentPicture(studentId);
        }





}
