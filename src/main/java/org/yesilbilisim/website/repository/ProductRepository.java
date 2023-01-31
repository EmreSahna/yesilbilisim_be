package org.yesilbilisim.website.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 import org.yesilbilisim.website.model.Products.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select max(price) from Product")
    double findMaxPrice();

    @Query("SELECT p FROM Product p WHERE p.brand.name IN :brands AND p.category.name IN :categories AND p.price <= :maxPrice")
    Page<Product> findAllByFilter(List<String> brands, List<String> categories, double maxPrice, Pageable pageable);
}
