package org.yesilbilisim.website.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageModel saveImage(String name, String folder, MultipartFile photo) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        File file = new File(uploadDir + "/" + folder + "/" + fileName);
        try {
            photo.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageRepository.save(ImageModel.builder()
                .name(name)
                .path(folder+"/"+photo.getOriginalFilename())
                .build());
    }

    public List<ImageModel> getLogos() {
        return imageRepository.findAll();
    }
}
