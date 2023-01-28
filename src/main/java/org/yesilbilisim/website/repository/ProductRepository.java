package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.Products.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
