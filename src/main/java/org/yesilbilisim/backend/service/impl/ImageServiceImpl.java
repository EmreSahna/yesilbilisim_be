package org.yesilbilisim.backend.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.backend.entity.Images.Image;
import org.yesilbilisim.backend.service.ImageService;

import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Override
    public Image saveImageBsc(String folder, MultipartFile photo) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        saveImage(photo, folder, fileName);

        return Image.builder()
                .folder(folder)
                .filename(fileName)
                .build();
    }

    private void saveImage(MultipartFile photo, String folder, String fileName){
        File file = new File(uploadDir + "/" + folder + "/" + fileName);
        try {
            photo.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
