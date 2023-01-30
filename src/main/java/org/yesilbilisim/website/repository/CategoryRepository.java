package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.Products.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
