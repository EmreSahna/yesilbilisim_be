package org.yesilbilisim.website.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.service.ImageService;

import java.util.List;

@RestController
@RequestMapping("/image")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/save")
    public ResponseEntity<ImageModel> saveImage(@RequestParam("file") MultipartFile photo,
                                                @RequestParam("name") String name,
                                                @RequestParam("folder") String folder) {
        return new ResponseEntity<>(imageService.saveImage(name, folder, photo), HttpStatus.CREATED);
    }

    @GetMapping("/logos")
    public ResponseEntity<List<ImageModel>> getLogos() {
        return new ResponseEntity<>(imageService.getLogos(), HttpStatus.OK);
    }
}
