package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}
