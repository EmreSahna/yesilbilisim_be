package org.yesilbilisim.website.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCardResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private BrandResponse brand;
    private ProductImageResponse image;
}
