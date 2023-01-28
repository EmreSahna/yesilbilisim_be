package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.Products.ProductImage;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    List<ProductImage> findAllByProductId(Long productId);
}
