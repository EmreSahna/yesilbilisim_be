package org.yesilbilisim.backend.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.backend.entity.Images.Image;
import org.yesilbilisim.backend.repository.ImageRepository;
import org.yesilbilisim.backend.service.ImageService;

import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImageBsc(String folder, MultipartFile photo) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        saveImage(photo, folder, fileName);

        return imageRepository.save(Image
                .builder()
                .filename(fileName)
                .folder(folder)
                .build());
    }

    public void saveImage(MultipartFile photo, String folder, String fileName){
        File file = new File(uploadDir + "/" + folder + "/" + fileName);
        try {
            photo.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
