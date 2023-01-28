package org.yesilbilisim.website.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageResponse {
    private String name;
    private String brand;
    private double price;
    private String image;
}
