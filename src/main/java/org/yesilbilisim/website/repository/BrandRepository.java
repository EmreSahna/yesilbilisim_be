package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.Products.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
