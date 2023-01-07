package org.yesilbilisim.website.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yesilbilisim.website.dto.request.ImageRequestDto;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.repository.ImageRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageModel saveImage(ImageRequestDto imageModel, String folder) {
        return imageRepository.save(ImageModel.builder()
                .name(imageModel.getName())
                .path(imageModel.getPath())
                .build());
    }

    public List<ImageModel> getLogos() {
        return imageRepository.findAll();
    }
}
