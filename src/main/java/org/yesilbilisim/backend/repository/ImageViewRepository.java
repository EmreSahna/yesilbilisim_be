package org.yesilbilisim.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.backend.entity.Views.ImageView;
import org.yesilbilisim.backend.entity.Views.ViewType;

import java.util.List;

public interface ImageViewRepository extends JpaRepository<ImageView, Long>{
    List<ImageView> findAllByType(ViewType type);
}
