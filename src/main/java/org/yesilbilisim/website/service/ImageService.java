package org.yesilbilisim.website.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.model.DescriptionalImageModel;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.repository.DescriptionalRepository;
import org.yesilbilisim.website.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ImageService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    private final ImageRepository imageRepository;
    private final DescriptionalRepository descriptionalRepository;

    public ImageService(ImageRepository imageRepository, DescriptionalRepository descriptionalRepository) {
        this.imageRepository = imageRepository;
        this.descriptionalRepository = descriptionalRepository;
    }

    public ImageModel saveImageBsc(String folder, MultipartFile photo) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        saveImage(photo, folder, fileName);

        return imageRepository.save(ImageModel
                .builder()
                .filename(fileName)
                .folder(folder)
                .build());
    }

    public DescriptionalImageModel saveImageAdv(String folder, MultipartFile photo, String title, String description) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        saveImage(photo, folder, fileName);

        return descriptionalRepository.save(DescriptionalImageModel
                .builder()
                .filename(fileName)
                .folder(folder)
                .title(title)
                .description(description)
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

    public List<ImageModel> getHomepage() {
        List<ImageModel> companies = imageRepository.findByFolder("companies");
        List<ImageModel> services = imageRepository.findByFolder("services");
        List<ImageModel> homepageImages = Stream.concat(services.stream(), companies.stream()).collect(Collectors.toList());
        return homepageImages;
    }

    public List<ImageModel> getSlider() {
        return imageRepository.findByFolder("carousel");
    }
}
