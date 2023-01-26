package org.yesilbilisim.website.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.website.model.DescriptionalImageModel;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.model.TitledImageModel;
import org.yesilbilisim.website.repository.DescriptionalRepository;
import org.yesilbilisim.website.repository.ImageRepository;
import org.yesilbilisim.website.repository.TitledRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@EnableCaching
public class ImageService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    private final RedisTemplate<String, List<ImageModel>> redisTemplate;
    private final ImageRepository imageRepository;
    private final DescriptionalRepository descriptionalRepository;
    private final TitledRepository titledRepository;

    public ImageService(RedisTemplate<String, List<ImageModel>> redisTemplate, ImageRepository imageRepository, DescriptionalRepository descriptionalRepository, TitledRepository titledRepository) {
        this.redisTemplate = redisTemplate;
        this.imageRepository = imageRepository;
        this.descriptionalRepository = descriptionalRepository;
        this.titledRepository = titledRepository;
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

    public ImageModel saveImageMid(String folder, MultipartFile photo, String title) {
        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        saveImage(photo, folder, fileName);

        return titledRepository.save(TitledImageModel
                .builder()
                .filename(fileName)
                .folder(folder)
                .title(title)
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

    public void saveDataToRedis(String key, List<ImageModel> data, long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, data);
        redisTemplate.expire(key, time, timeUnit);
    }

    public List<ImageModel> getDataFromRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public List<ImageModel> getHomepage() {
        List<ImageModel> homepageImages = getDataFromRedis("homepage");

        if (homepageImages != null) {
            return homepageImages;
        }

        List<ImageModel> companies = imageRepository.findByFolder("companies");
        List<ImageModel> services = imageRepository.findByFolder("services");
        List<ImageModel> carousel = imageRepository.findByFolder("carousel");
        List<ImageModel> homepage = imageRepository.findByFolder("homepage");
        homepageImages = Stream.of(homepage.stream(), services.stream(), companies.stream(), carousel.stream())
                .reduce(Stream::concat)
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());

        saveDataToRedis("homepage", homepageImages, 10, TimeUnit.MINUTES);

        return homepageImages;
    }

    public List<ImageModel> getSolutionpage() {
        List<ImageModel> solutionpageImages = getDataFromRedis("solutionpage");

        if (solutionpageImages != null) {
            return solutionpageImages;
        }

        solutionpageImages = imageRepository.findByFolder("solutions");

        saveDataToRedis("solutionpage", solutionpageImages, 5, TimeUnit.MINUTES);

        return solutionpageImages;
    }
}
