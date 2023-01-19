package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.ImageModel;

import java.awt.*;
import java.util.List;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    List<ImageModel> findByFolder(String folder);
}
