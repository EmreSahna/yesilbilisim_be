package org.yesilbilisim.website.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/save/basic")
    public ResponseEntity<ImageModel> saveImage(@RequestParam("file") MultipartFile photo,
                                                @RequestParam("folder") String folder) {
        return new ResponseEntity<>(imageService.saveImageBsc(folder, photo), HttpStatus.CREATED);
    }

    @PostMapping("/save/mid")
    public ResponseEntity<ImageModel> saveImage(@RequestParam("file") MultipartFile photo,
                                                @RequestParam("folder") String folder,
                                                @RequestParam("title") String title) {
        return new ResponseEntity<>(imageService.saveImageMid(folder, photo, title), HttpStatus.CREATED);
    }

    @PostMapping("/save/advanced")
    public ResponseEntity<ImageModel> saveImage(@RequestParam("file") MultipartFile photo,
                                                @RequestParam("folder") String folder,
                                                @RequestParam("title") String title,
                                                @RequestParam("description") String description) {
        return new ResponseEntity<>(imageService.saveImageAdv(folder, photo, title, description), HttpStatus.CREATED);
    }

    @GetMapping("/slider")
    public ResponseEntity<List<ImageModel>> getSlider() {
        return new ResponseEntity<>(imageService.getSlider(), HttpStatus.OK);
    }

    @GetMapping("/homepage")
    public ResponseEntity<List<ImageModel>> getHomepage() {
        return new ResponseEntity<>(imageService.getHomepage(), HttpStatus.OK);
    }
}
