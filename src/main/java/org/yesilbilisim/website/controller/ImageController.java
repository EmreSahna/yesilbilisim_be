package org.yesilbilisim.website.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yesilbilisim.website.dto.request.ImageRequestDto;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/image")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/save/{folder}")
    public ResponseEntity<ImageModel> saveImage(@PathVariable String folder, @RequestBody ImageRequestDto imageModel) {
        return new ResponseEntity<>(imageService.saveImage(imageModel, folder), HttpStatus.CREATED);
    }

    @GetMapping("/logos")
    public ResponseEntity<List<ImageModel>> getLogos() {
        return new ResponseEntity<>(imageService.getLogos(), HttpStatus.OK);
    }

}
