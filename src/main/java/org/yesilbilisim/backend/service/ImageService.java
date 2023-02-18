package org.yesilbilisim.backend.service;

import org.springframework.web.multipart.MultipartFile;
import org.yesilbilisim.backend.entity.Images.Image;

public interface ImageService {
    Image saveImageBsc(String folder, MultipartFile photo);
}