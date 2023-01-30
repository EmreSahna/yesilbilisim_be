package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yesilbilisim.website.model.Products.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select max(price) from Product")
    double findMaxPrice();
}
