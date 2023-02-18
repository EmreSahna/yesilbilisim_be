package org.yesilbilisim.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.backend.entity.Images.Image;
import org.yesilbilisim.backend.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/save")
    public ResponseEntity<Image> saveImage(@RequestParam("file") MultipartFile photo,
                                           @RequestParam("folder") String folder) {
        return new ResponseEntity<>(imageService.saveImageBsc(folder, photo), HttpStatus.CREATED);
    }
}
